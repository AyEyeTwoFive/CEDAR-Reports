import java.time.LocalDateTime;

/** Result for number of artifacts report.
 *  List of templates per user
 *  Datetime
 */
public class NumberOfArtifactsResult {
  public List<Integer> templatesPerUser;
  public List<Integer> elementsPerUser;
  public List<Integer> fieldsPerUser;
  public List<Integer> instancesPerUser;
  public List<Integer> artifactsPerUser;
  public LocalDateTime now;
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
  public List<Integer> getTemplatesPerUser(string folder) {

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
  public List<Integer> getInstancesPerUser(string folder) {
  }

  /**
   * Returns a list of number of templates per user sorted in decreasing order
   * of the number of templates the user has produced, along with a timestamp.
   * @param  folder the directory to include in analysis
   * @return List<Integer> list templatesPerUser;
   */
  public List<Integer> getArtifactsPerUser(string folder) {
  }

}