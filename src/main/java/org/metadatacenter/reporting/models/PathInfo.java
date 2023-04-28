package org.metadatacenter.reporting.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class PathInfo {
  public String resourceType;
  public boolean activeUserCanRead;
  public String everybodyPermission;
  public boolean isSystem;
  public boolean isRoot;
  public boolean isUserHome;

  @JsonProperty("@id")
  public String id;
  public String ownedBy;
  public String ownedByUserName;

  @JsonProperty("pav:createdBy")
  public String pav_createdBy;

  @JsonProperty("oslc:modifiedBy")
  public String oslc_modifiedBy;
  public String createdByUserName;
  public String lastUpdatedByUserName;

  @JsonProperty("schema:name")
  public String schema_name;

  @JsonProperty("schema:description")
  public String schema_description;

  @JsonProperty("schema:identifier")
  public Object schema_identifier;

  @JsonProperty("pav:createdOn")
  public Date pav_createdOn;

  @JsonProperty("pav:lastUpdatedOn")
  public Date pav_lastUpdatedOn;
  public Object sourceHash;
}
