import java.time.LocalDateTime;

/** Result for number of artifacts report.
 *  List of templates per user
 *  Datetime
 */
public class NumberOfArtifactsResult {
  private List<Integer> templatesPerUser;
  private List<Integer> elementsPerUser;
  private List<Integer> fieldsPerUser;
  private List<Integer> instancesPerUser;
  private List<Integer> artifactsPerUser;
  private LocalDateTime now;
}

/** Class to generate reports for numbers of artifacts
 *
 */
public class numberOfArtifacts {

  /**
   * Returns a list of number of templates per user sorted in decreasing order
   * of the number of templates the user has produced, along with a timestamp.
   * @param  folder the directory to include in analysis
   * @return List<Integer> list templatesPerUser;
   */
  public List<Integer> getTemplatesPerUser(String folder) {

  }

  /**
   * Returns a list of number of templates per user sorted in decreasing order
   * of the number of templates the user has produced, along with a timestamp.
   * @param  folder the directory to include in analysis
   * @return List<Integer> list templatesPerUser;
   */
  public List<Integer> getElementsPerUser(string folder) {
  }

  /**
   * Returns a list of number of templates per user sorted in decreasing order
   * of the number of templates the user has produced, along with a timestamp.
   * @param  folder the directory to include in analysis
   * @return List<Integer> list templatesPerUser;
   */
  public List<Integer> getFieldsPerUser(string folder) {
  }

  /**
   * Returns a list of number of templates per user sorted in decreasing order
   * of the number of templates the user has produced, along with a timestamp.
   * @param  folder the directory to include in analysis
   * @return List<Integer> list templatesPerUser;
   */
  public List<Integer> getInstancesPerUser(String folder) {
  }

  /**
   * Returns a list of number of templates per user sorted in decreasing order
   * of the number of templates the user has produced, along with a timestamp.
   * @param  folder the directory to include in analysis
   * @return List<Integer> list templatesPerUser;
   */
  public List<Integer> getArtifactsPerUser(String folder) {
  }




  /**
   * Main method
   * @param  args
   * @return none
   */
  public static void main (String[] args) {
    folder = args[1];
    JavaGet(folder);

  }

}