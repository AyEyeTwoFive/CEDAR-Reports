package org.metadatacenter.reporting;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class GetFolderContents {
  public static void main(String[] args) throws IOException {
    String folderId = "https://repo.metadatacenter.net/folders/fbb59cef-3bdc-4faf-b327-42de9d7acd81";
    String requestUrl = "https://resource.metadatacenter.org/folders/";
    requestUrl += URLEncoder.encode(folderId, StandardCharsets.UTF_8);
    requestUrl += "/contents?limit=100&offset=0&publication_status=all&resource_types=element,field,instance," +
        "template,folder&sort=name&version=latest-by-status";

    String apiKey = "<GET_YOUR_API_KEY HERE>";
    URL url = new URL(requestUrl);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.setRequestProperty("Authorization", "apiKey " + apiKey);
    connection.connect();

    int responseCode = connection.getResponseCode();
    if (responseCode == 200) {
      InputStream responseStream = connection.getInputStream();
      String result = IOUtils.toString(responseStream, StandardCharsets.UTF_8);
      System.out.println(result);
      System.out.println("The request was successful.");
    } else {
      System.out.println("The request failed.");
      System.out.println("Response code: " + responseCode);
    }
  }
}

