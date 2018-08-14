package practice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "name",
  "type",
  "nullable",
  "metadata"
})
public class Field {

  @JsonProperty("name")
  public String name;
  @JsonProperty("type")
  public String type;
  @JsonProperty("nullable")
  public Boolean nullable;
  @JsonProperty("metadata")
  public Metadata metadata;
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Boolean getNullable() {
    return nullable;
  }

  public void setNullable(Boolean nullable) {
    this.nullable = nullable;
  }

  public Metadata getMetadata() {
    return metadata;
  }

  public void setMetadata(Metadata metadata) {
    this.metadata = metadata;
  }

  @Override
  public String toString() {
    return "Field [name=" + name + ", type=" + type + ", nullable=" + nullable + ", metadata="
        + metadata + "]";
  }

}
