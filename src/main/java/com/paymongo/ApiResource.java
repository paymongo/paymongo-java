package main.java.com.paymongo;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ApiResource
 */
public class ApiResource {

  public Object data;
  public Object attributes;
  public String id;
  public boolean has_more;

  @JsonProperty("data")
  private void unpackNested(Map<String, Object> data) {
    this.data = data;

    if (data.containsKey("attributes")) {
      this.id = (String) data.get("id");
      Map<String, Object> attributes = (Map<String, Object>) data.get("attributes");
      this.attributes = attributes;
    }
  }
}
