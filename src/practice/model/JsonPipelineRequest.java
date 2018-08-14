package practice.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "type",
  "fields"
})
public class JsonPipelineRequest {

  @JsonProperty("type")
  public String type;
  @JsonProperty("fields")
  public List<Field> fields = null;
  
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public List<Field> getFields() {
    return fields;
  }

  public void setFields(List<Field> fields) {
    this.fields = fields;
  }

  @Override
  public String toString() {
    return "JsonPipelineRequest [type=" + type + ", fields=" + fields + "]";
  }

}