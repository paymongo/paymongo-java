package main.java.com.paymongo.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URISyntaxException;

import main.java.com.paymongo.ApiResource;
import main.java.com.paymongo.PaymongoClient;
import main.java.com.paymongo.entities.PaymentIntentEntity;

/**
 * BaseService
 */
public class BaseService {

  public static Object request(String entity, String method, String path, String payload) {

    try {
      ApiResource api_resource = PaymongoClient.execute_request(method, payload, path);

      return map_response(entity, api_resource);
    } catch (URISyntaxException | IOException | InterruptedException e) {
      e.printStackTrace();
    }

    return null;
  }

  private static Object map_response(String entity, ApiResource api_resource) {
    ObjectMapper mapper = new ObjectMapper();

    switch (entity) {
      case "PaymentIntentEntity":
        return mapper.convertValue(api_resource.data, PaymentIntentEntity.class);
    }

    return null;
  }
}
