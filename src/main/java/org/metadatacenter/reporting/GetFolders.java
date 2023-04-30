package org.metadatacenter.reporting;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.metadatacenter.reporting.models.Root;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/** Class to perform a get operation on a URL
 *  CEDAR API Key comes from environment variable
 *  CEDAR folder to run analytics on is passed in as a command line argument
 *  Use the twilio example to open an HTTP Connection
 *   https://www.twilio.com/blog/5-ways-to-make-http-requests-in-java
 *  Replicates the curl example shown below
 *   curl -X GET --header "Accept: application/json" --header "Authorization: apiKey XXX" "https://resource.metadatacenter.org/folders/https%3A%2F%2Frepo.metadatacenter.org%2Ffolders%2F1ee5ef41-0605-4c18-9054-b01eb4290339/contents?resource_types=template&version=all&publication_status=all&sort=name&limit=100" | jq '.resources[]."schema:name"'
 */
public class GetFolders {
  /**
   * Perform get request on a CEDAR folder
   *
   * @param folder       The folder to run the analysis on
   * @return pathInfo object which contains information about ownership of resources
   */
  public static List<Root> Get(String folder) throws IOException {

    // First make sure we have API key
    String apiKey = null;
    try {
      apiKey = System.getenv("API_KEY");
    } catch (SecurityException e) {
      System.out.println("A security manager is preventing access to the CEDAR API Key");
    }
    if (apiKey == null) {
      System.out.println("No CEDAR API Key was found");
    }

    // Build request endpoint
    String endpoint = "https://resource.metadatacenter.org/folders/";
    // https:%2F%2Frepo.metadatacenter.org%2Ffolders%2F1de27fa4-3743-4c56-b2df-713a27657949
    String encoded_folder = URLEncoder.encode(folder);
    endpoint = endpoint + encoded_folder;

    //Add parameters
    //System.out.println(endpoint);
    endpoint += "/contents?resource_types=folder" + "&version=all&publication_status=all&sort=name&limit=100";

    int totalCount;
    int currentOffset;

    Root response;

    // Initialize list to store folders
    List<Root> folders = new ArrayList<Root>();

    do {

      //Create URL and connection
      URL url;
      HttpURLConnection connection = null;
      try {
        // Open a connection(?) on the URL(??) and cast the response(???)
        url = new URL(endpoint);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        // Now it's "open", we can set the request method, headers etc.
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Authorization", "apiKey " + apiKey);
      } catch (ProtocolException e) {
        System.err.println("Protocol Error establishing request: " + e.getMessage());
        System.exit(-1);
      } catch (IOException e) {
        System.err.println("IO Error when establishing request to URL: " + e.getMessage());
        System.exit(-1);
      }

      //Check response and throw error if necessary
      int responseCode = 0;
      try {
        responseCode = connection.getResponseCode();
      } catch (IOException e) {
        System.err.println("Error obtaining HTTP result, response code: " + responseCode + " " + e.getMessage());
        System.exit(-1);
      }

      // This line makes the request
      InputStream responseStream = null;
      try {
        responseStream = connection.getInputStream();
      } catch (IOException e) {
        System.err.println("IO Error reading response from request: " + e.getMessage());
        System.exit(-1);
      }

      // print inputstream
//      byte[] buffer = new byte[1024];
//      int bytesRead;
//      while ((bytesRead = responseStream.read(buffer)) != -1) {
//        System.out.println(new String(buffer, 0, bytesRead));
//      }
//      ObjectMapper printMapper = new ObjectMapper();
//      printMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
//      String prettyJson = printMapper.writeValueAsString(printMapper.readValue(responseStream, Object.class));
//      System.out.println(prettyJson);


      // Manually converting the response body InputStream to Java class using Jackson
      ObjectMapper mapper = new ObjectMapper();
      response = null;
      try {
        response = mapper.readValue(responseStream, Root.class);
      } catch (IOException e) {
        if (e.getMessage().contains("No content to map")) { // nothing to do
          ;
        }
        else {
          System.out.println("IO Error when deserializing response: " + e.getMessage());
        }
      }


      // Add data to dictionary
      if (response != null) {

//        // Print out details
//        System.out.println("Total count: " + response.totalCount);
//        System.out.println("Current offset: " + response.currentOffset);
//        System.out.println("First page: " + response.paging.first);
//        System.out.println("Last page: " + response.paging.last);

        // Save to response variable
        totalCount = response.totalCount;
        endpoint = response.paging.last;
        currentOffset = response.currentOffset;
        folders.add(response);
      }

    }

    //while (currentOffset > 0);
    while (response != null && response.paging.next != null);

    // Recursively add folders
//    int prevLen = 0;
//    while (folders.size() > prevLen) {
//      for (Root f : folders) {        // loop through folders
//        Object addFolders = f.listFiles();
//        folders = folders + addFolders;
//      }
//    }

    // Return the data
    return folders;

  }
}




