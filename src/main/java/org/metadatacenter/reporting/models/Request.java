package org.metadatacenter.reporting.models;

import java.util.ArrayList;

public class Request{
  public String version;
  public String publicationStatus;
  public int limit;
  public int offset;
  public ArrayList<String> sort;
  public Object q;
  public Object id;
  public Object categoryId;
  public Object mode;
  public ArrayList<String> resource_types;
  public Object is_based_on;
}
