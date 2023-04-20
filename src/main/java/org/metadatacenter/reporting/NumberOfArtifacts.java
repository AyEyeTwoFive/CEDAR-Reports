package org.metadatacenter.reporting;
import java.time.LocalDateTime;
import java.util.Hashtable;
import java.util.List;
import org.metadatacenter.reporting.models.PathInfo;
import org.metadatacenter.reporting.GetRequest;
import org.metadatacenter.reporting.models.Root;

import static org.metadatacenter.reporting.GetRequest.*;

/** Class to generate reports for numbers of artifacts
 *
 */
public class NumberOfArtifacts {

  /**
   * Returns a list of number of templates per user sorted in decreasing order
   * of the number of templates the user has produced, along with a timestamp.
   * @param  folder the directory to include in analysis
   * @return List<Integer> list templatesPerUser;
   */
  public static List<Integer> getTemplatesPerUser(String folder) {
    List<Root> authors = Get(folder, "folder");
    System.out.println(authors);
    return null;
  }

  /**
   * Returns a list of number of templates per user sorted in decreasing order
   * of the number of templates the user has produced, along with a timestamp.
   * @param  folder the directory to include in analysis
   * @return List<Integer> list templatesPerUser;
   */
  public List<Integer> getElementsPerUser(String folder) {
    return null;
  }

  /**
   * Returns a list of number of templates per user sorted in decreasing order
   * of the number of templates the user has produced, along with a timestamp.
   * @param  folder the directory to include in analysis
   * @return List<Integer> list templatesPerUser;
   */
  public List<Integer> getFieldsPerUser(String folder) {
    return null;
  }

  /**
   * Returns a list of number of templates per user sorted in decreasing order
   * of the number of templates the user has produced, along with a timestamp.
   * @param  folder the directory to include in analysis
   * @return List<Integer> list templatesPerUser;
   */
  public List<Integer> getInstancesPerUser(String folder) {
    return null;
  }

  /**
   * Returns a list of number of templates per user sorted in decreasing order
   * of the number of templates the user has produced, along with a timestamp.
   * @param  folder the directory to include in analysis
   * @return List<Integer> list templatesPerUser;
   */
  public List<Integer> getArtifactsPerUser(String folder) {
    return null;
  }


  /** Main method to generate reports for a given folder in CEDAR
   *
   * @param args
   */
  public static void main (String[] args) {
    String folder = args[0];
    getTemplatesPerUser(folder);
  }

}