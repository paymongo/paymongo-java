package main.java.com.paymongo;

import java.util.Map;
/**
 * ApiResource
 */
public class ApiResource {

  public Object attributes;
  public Object data;
  public String id;
  public boolean has_more;

  public ApiResource(Map<String, Object> response) {
    this.data = (Map<String, Object>) response.get("data");

    if (((Map<String, Object>) data).containsKey("attributes")) {
      this.attributes = ((Map<String, Object>) data).get("attributes");
      this.id = (String) ((Map<String, String>) data).get("id");
    }
  }
}
