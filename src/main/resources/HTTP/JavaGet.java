
/** Class to perform a get operation on a URL
 *   https://www.twilio.com/blog/5-ways-to-make-http-requests-in-java
 */
public class JavaGet {

  public static void main(String args[]) {

    // First make sure we have API key
    try {
      String apiKey = System.getenv("API_KEY")
    }
    catch (NullPointerException e) {
      System.out.println("No API Key was found")
    }
    catch (SecurityException e) {
      System.out.println("A security manager is preventing access to API Key")
    }
    if (apiKey == null) {
      System.out.println("No API Key was found")
    }

    // Create a neat value object to hold the URL
    URL url = new URL(url);

    // Open a connection(?) on the URL(??) and cast the response(???)
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    // Now it's "open", we can set the request method, headers etc.
    connection.setRequestProperty("accept", "application/json");

    // Add API Key
    String user = System.getProperty("user.name");

    // This line makes the request
    InputStream responseStream = connection.getInputStream();

    // Manually converting the response body InputStream to APOD using Jackson
    ObjectMapper mapper = new ObjectMapper();
    APOD apod = mapper.readValue(responseStream, APOD.class);

    // Finally we have the response
    System.out.println(apod.title);
  }
}




