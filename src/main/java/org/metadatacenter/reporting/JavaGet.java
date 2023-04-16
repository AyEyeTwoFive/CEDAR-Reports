package org.metadatacenter.reporting;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/** Class to perform a get operation on a URL
 *  CEDAR API Key comes from environment variable
 *  CEDAR folder to run analytics on is passed in as a command line argument
 *  Use the twilio example to open an HTTP Connection
 *  Replicates the curl example shown below

 *   https://www.twilio.com/blog/5-ways-to-make-http-requests-in-java
 *   curl -X GET --header "Accept: application/json" --header "Authorization: apiKey XXX" "https://resource.metadatacenter.org/folders/https%3A%2F%2Frepo.metadatacenter.org%2Ffolders%2F1ee5ef41-0605-4c18-9054-b01eb4290339/contents?resource_types=template&version=all&publication_status=all&sort=name&limit=100" | jq '.resources[]."schema:name"'
 */
public class JavaGet {

  public static void main(String args[]) throws IOException {

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
    // Create a neat value object to hold the URL
    String folder;
    folder = args[0];
    URL url = new URL(folder);

    // Open a connection(?) on the URL(??) and cast the response(???)
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    connection.setRequestMethod("GET");

    // Now it's "open", we can set the request method, headers etc.
    connection.setRequestProperty("Accept", "application/json");

    connection.setRequestProperty("Authorization", "apiKey " +  apiKey);

    int responseCode = connection.getResponseCode();

    // Add API Key
    //String user = System.getProperty("user.name");

    // This line makes the request
    InputStream responseStream = connection.getInputStream();

    // Manually converting the response body InputStream to APOD using Jackson
    ObjectMapper mapper = new ObjectMapper();
    //APOD apod = mapper.readValue(responseStream, APOD.class);

    // Finally we have the response
    //System.out.println(apod.title);
  }
}




