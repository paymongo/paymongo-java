package com.paymongo.services;

import com.paymongo.entities.ListingEntity;
import com.paymongo.entities.WebhookEntity;

public class Webhook extends BaseService {
  public static final String URI = "webhooks";

  public static ListingEntity all() {
    return (ListingEntity) request(
      "WebhookEntity",
      "GET",
      URI,
      null,
      true
    );
  }

  public static WebhookEntity create(Object payload) {
    return (WebhookEntity) request(
      "WebhookEntity",
      "POST",
      URI,
      payload,
      false
    );
  }

  public static WebhookEntity disable(String id) {
    return (WebhookEntity) request(
      "WebhookEntity",
      "POST",
      URI + "/" + id + "/disable",
      null,
      false
    );
  }

  public static WebhookEntity enable(String id) {
    return (WebhookEntity) request(
      "WebhookEntity",
      "POST",
      URI + "/"+ id + "/enable",
      null,
      false
    );
  }

  public static WebhookEntity retrieve(String id) {
    return (WebhookEntity) request(
      "WebhookEntity",
      "GET",
      URI + "/" + id,
      null,
      false
    );
  }

  public static WebhookEntity update(String id, Object payload) {
    return (WebhookEntity) request(
      "WebhookEntity",
      "PUT",
      URI + "/" + id,
      payload,
      false
    );
  }
}
