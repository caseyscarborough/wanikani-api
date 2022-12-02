package com.wanikani.api.v2;

import com.wanikani.api.v2.exception.WaniKaniException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;

class HttpClient {

    private final OkHttpClient client;
    private final String apiKey;

    HttpClient(String apiKey) {
        this.apiKey = apiKey;
        this.client = new OkHttpClient.Builder().build();
    }

    String get(String url) {
        Request request = new Request.Builder()
            .get()
            .header("Authorization", String.format("Bearer %s", apiKey))
            .header("Wanikani-Revision", Constants.API_REVISION)
            .url(url)
            .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new WaniKaniException(getError(response));
            }
            final ResponseBody body = response.body();
            if (body == null) {
                throw new WaniKaniException("Response from API was missing.");
            }
            return body.string();
        } catch (IOException e) {
            throw new WaniKaniException("An IO error occurred while performing request", e);
        }
    }

    private String getError(Response response) {
        switch (response.code()) {
            case 401:
                return "401 Unauthorized: Wanikani API key is likely incorrect or invalid";
            case 403:
                return "403 Forbidden";
            case 404:
                return "404 Not Found";
            case 422:
                return "422 Unprocessable Entity";
            case 429:
                return "429 Rate Limit Exceeded: The rate limit for this request is " +
                    response.header("RateLimit-Limit") +
                    " for this period. The rate limit will reset at " +
                    response.header("RateLimit-Reset");
            case 500:
                return "500 Internal Server Error: Please try the request again later";
            case 503:
                return "503 Service Unavailable: Please try the request again later";
            default:
                return "An error occurred communicating with the API. Please try again later";
        }
    }
}
