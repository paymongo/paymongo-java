package com.paymongo.services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import com.paymongo.ApiResource;
import com.paymongo.PaymongoClient;
import com.paymongo.entities.PaymentIntentEntity;

/**
 * BaseService
 */
public class BaseService {
  public static Object request(String entity, String method, String path, Object payload) {
    try {
      ApiResource api_resource = PaymongoClient.execute_request(method, payload, path);

      return map_response(entity, api_resource);
    } catch (URISyntaxException | IOException | InterruptedException e) {
      e.printStackTrace();
    }

    return null;
  }

  private static Object map_response(String entity, ApiResource api_resource) {
    switch (entity) {
      case "PaymentIntentEntity":
        return new PaymentIntentEntity((Map<String, Object>) api_resource.data);
    }

    return null;
  }
}
