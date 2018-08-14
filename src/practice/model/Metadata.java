package practice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({

})
public class Metadata {

  @Override
  public String toString() {
    return "Metadata []";
  }
  
}