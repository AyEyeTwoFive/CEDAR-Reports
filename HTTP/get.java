
/** Class to perform a get operation on a URL
 *   https://www.twilio.com/blog/5-ways-to-make-http-requests-in-java
 */
public class JavaGet {

  public string httpGet(string url) {

  // Create a neat value object to hold the URL
  URL url = new URL(url);

  // Open a connection(?) on the URL(??) and cast the response(???)
  HttpURLConnection connection = (HttpURLConnection) url.openConnection();

  // Now it's "open", we can set the request method, headers etc.
  connection.setRequestProperty("accept","application/json");

  // This line makes the request
  InputStream responseStream = connection.getInputStream();

  // Manually converting the response body InputStream to APOD using Jackson
  ObjectMapper mapper = new ObjectMapper();
  APOD apod = mapper.readValue(responseStream, APOD.class);

  // Finally we have the response
  System.out.println(apod.title);

}