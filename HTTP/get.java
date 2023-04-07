
/** Class to perform a get operation on a URL
 *
 */
public class JavaGet {

  public
  URL url = new URL("http://example.com");
  HttpURLConnection con = (HttpURLConnection) url.openConnection();
  con.setRequestMethod("GET");