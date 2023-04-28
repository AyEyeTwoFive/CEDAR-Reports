package org.metadatacenter.reporting.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Root{
  public Request request;
  public int totalCount;
  public int currentOffset;
  public Paging paging;
  public ArrayList<Object> resources;
  public ArrayList<PathInfo> pathInfo;
  public String nodeListQueryType;
  public Object categoryName;
  public Object categoryPath;

  @JsonProperty("@context")
  public Context context;
  public PathInfo pathinfo;
}
