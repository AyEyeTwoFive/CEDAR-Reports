package org.metadatacenter.reporting;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetFolderContents {
  public static void main(String[] args) throws IOException {
    URL url = new URL(args[1]);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.connect();

    int responseCode = connection.getResponseCode();
    if (responseCode == 200) {
      System.out.println("The request was successful.");
    } else {
      System.out.println("The request failed.");
      System.out.println("Response code: " + responseCode);
    }
  }
}

