package org.metadatacenter.reporting;
import java.io.IOException;
import java.util.*;

import org.metadatacenter.reporting.models.PathInfo;
import org.metadatacenter.reporting.models.Root;

import static org.metadatacenter.reporting.GetFolders.*;

/** Class to generate reports for numbers of artifacts
 *
 */
public class NumberOfArtifacts {

  /**
   * Returns a list of number of templates per user sorted in decreasing order
   * of the number of templates the user has produced, along with a timestamp.
   * @param  folder the directory to include in analysis
   * @param resourceType The type of resource of interest,
   *                     can be "template", "element", "field", "instance", or "artifact"
   * @return List<Integer> list templatesPerUser;
   */
  public static List<Integer> getResourcesPerUser(String folder, String resourceType) throws IOException {
    List<Root> folders = Get(folder, "folder");
    Hashtable<String, String> idsAndAuthors = new Hashtable<String, String>();
    for (Root f: folders) {        // loop through folders
      for (PathInfo p : f.pathInfo) {  // loop through content within folders
        if (p.resourceType == resourceType) {     // if resource is the type of interest
          idsAndAuthors.put(p.id, p.pav_createdBy);  // add to dictionary
        }
      }
    }
    Hashtable<String, Integer> authorCounts = new Hashtable<String, Integer>(); // how many times each author appears
    for (Map.Entry<String,String> entry: idsAndAuthors.entrySet()) {   // loop through resources
      String id = entry.getKey();
      String author = entry.getValue();
      if (authorCounts.containsKey(author)) {   // if this author is already in author counts dictionary
        authorCounts.put(author, authorCounts.get(author) + 1); // increment count for this author
      }
      else {
        authorCounts.put(author, 1); // otherwise, put a 1 as our first count for this author
      }
    }
    List<Integer> counts = new ArrayList<Integer>(); // list of counts only
    for (Map.Entry<String,Integer> entry: authorCounts.entrySet()) {     // loop through resources
      counts.add(entry.getValue());  // put the counts into a list
    }
    Collections.sort(counts); // sort the array
    return counts;
  }



  /** Main method to generate reports for a given folder in CEDAR
   *
   * @param args
   */
  public static void main (String[] args) throws IOException {
    String folder = args[0];
    List<Integer> templatesPerUser = getResourcesPerUser(folder, "template");
    List<Integer> elementsPerUser = getResourcesPerUser(folder, "element");
    List<Integer> fieldsPerUser = getResourcesPerUser(folder, "field");
    List<Integer> instancesPerUser = getResourcesPerUser(folder, "instance");
    List<Integer> artifactsPerUser = getResourcesPerUser(folder, "artifact");


  }

}