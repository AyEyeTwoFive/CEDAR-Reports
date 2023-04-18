package org.metadatacenter.reporting;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.metadatacenter.reporting.models.Root;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

/** Class to perform a get operation on a URL
 *  CEDAR API Key comes from environment variable
 *  CEDAR folder to run analytics on is passed in as a command line argument
 *  Use the twilio example to open an HTTP Connection
 *  Replicates the curl example shown below

 *   https://www.twilio.com/blog/5-ways-to-make-http-requests-in-java
 *   curl -X GET --header "Accept: application/json" --header "Authorization: apiKey XXX" "https://resource.metadatacenter.org/folders/https%3A%2F%2Frepo.metadatacenter.org%2Ffolders%2F1ee5ef41-0605-4c18-9054-b01eb4290339/contents?resource_types=template&version=all&publication_status=all&sort=name&limit=100" | jq '.resources[]."schema:name"'
 */
public class GetRequest {

  public static void main(String args[]) {

    // First make sure we have API key
    String apiKey = null;
    try {
      apiKey = System.getenv("API_KEY");
    }
    catch (SecurityException e) {
      System.out.println("A security manager is preventing access to the CEDAR API Key");
    }
    if (apiKey == null) {
      System.out.println("No CEDAR API Key was found");
    }

    // Build request endpoint
    String endpoint = "https://resource.metadatacenter.org/folders/";
    // https:%2F%2Frepo.metadatacenter.org%2Ffolders%2F1de27fa4-3743-4c56-b2df-713a27657949
    String folder;
    folder = args[0];
    String encoded_folder = URLEncoder.encode(folder);
    endpoint = endpoint + encoded_folder;

    //Add parameters
    System.out.println(endpoint);
    endpoint += "/contents?resource_types=template&version=all&publication_status=all&sort=name&limit=100";

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
      connection.setRequestProperty("Authorization", "apiKey " +  apiKey);
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

    // Manually converting the response body InputStream to APOD using Jackson
    ObjectMapper mapper = new ObjectMapper();
    Root response = null;
    try {
      response = mapper.readValue(responseStream, Root.class);
    } catch (IOException e) {
      System.out.println("IO Error when deserializing response: " + e.getMessage());
    }

    // Finally we have the response
    System.out.println("Total count: " + response.totalCount);
    System.out.println("Current offset: " + response.currentOffset);
    System.out.println("First page: "+ response.paging.first);
    System.out.println("Last page" +
        ": "+ response.paging.last);
  }
}




