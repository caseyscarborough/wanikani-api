package com.wanikani.api.v2;

import com.wanikani.api.v2.exception.WaniKaniException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class HttpClient {

    private final String apiKey;

    HttpClient(String apiKey) {
        this.apiKey = apiKey;
    }

    String request(String url) {
        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String input;
            StringBuilder response = new StringBuilder();

            while ((input = in.readLine()) != null) {
                response.append(input);
            }
            in.close();
            return response.toString();
        } catch (MalformedURLException e) {
            throw new WaniKaniException("URL was malformed: " + url, e);
        } catch (IOException e) {
            if (e.getMessage().contains("401")) {
                throw new WaniKaniException("WaniKani API key is likely incorrect or invalid", e);
            }
            throw new WaniKaniException("An IO error occurred while performing request", e);
        }
    }
}
