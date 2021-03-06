package com.wanikani.api.http;

import com.wanikani.api.exception.WaniKaniException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpClient {

  private static final String GET_REQUEST = "GET";

  public String request(String url) {
    try {
      URL obj = new URL(url);
      HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
      connection.setRequestMethod(GET_REQUEST);

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
      throw new WaniKaniException("An IO error occurred while performing request.", e);
    }
  }
}
