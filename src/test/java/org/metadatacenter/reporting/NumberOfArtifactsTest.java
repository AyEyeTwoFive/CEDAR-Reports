package org.metadatacenter.reporting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfArtifactsTest {

  @Test
  void getResourcesPerUser() {
    assertEquals(7, NumberOfArtifacts.getResourcesPerUser("https://repo.metadatacenter.org/folders/7f636e7c-8d35-4c3b-bd44-b09996e534cf","template"));
    assertEquals(3, NumberOfArtifacts.getResourcesPerUser("https://repo.metadatacenter.org/folders/7f636e7c-8d35-4c3b-bd44-b09996e534cf","field"));
    assertEquals(7, NumberOfArtifacts.getResourcesPerUser("https://repo.metadatacenter.org/folders/7f636e7c-8d35-4c3b-bd44-b09996e534cf","element"));
  }
}