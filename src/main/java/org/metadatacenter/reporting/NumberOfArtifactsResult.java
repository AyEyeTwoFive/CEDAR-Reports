package org.metadatacenter.reporting;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Result for number of artifacts report.
 * List of templates per user
 * Datetime
 */
public class NumberOfArtifactsResult {
  private List<Integer> templatesPerUser;
  private List<Integer> elementsPerUser;
  private List<Integer> fieldsPerUser;
  private List<Integer> instancesPerUser;
  private List<Integer> artifactsPerUser;
  private LocalDateTime now;
}
