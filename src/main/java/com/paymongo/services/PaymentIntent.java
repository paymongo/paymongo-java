package com.paymongo.services;

import com.paymongo.entities.PaymentIntentEntity;

public class PaymentIntent extends BaseService {
  public static final String URI = "payment_intents";

  public static PaymentIntentEntity attach(String id, Object payload) {
    return (PaymentIntentEntity) request(
      "PaymentIntentEntity",
      "POST",
      URI + "/" + id + "/attach",
      payload,
      false
    );
  }

  public static PaymentIntentEntity cancel(String id) {
    return (PaymentIntentEntity) request(
      "PaymentIntentEntity",
      "POST",
      URI + "/" + id + "/cancel",
      null,
      false
    );
  }

  public static PaymentIntentEntity capture(String id, Object payload) {
    return (PaymentIntentEntity) request(
      "PaymentIntentEntity",
      "POST",
      URI + "/" + id + "/capture",
      payload,
      false
    );
  }

  public static PaymentIntentEntity create(Object payload) {
    return (PaymentIntentEntity) request(
      "PaymentIntentEntity",
      "POST",
      URI,
      payload,
      false
    );
  }

  public static PaymentIntentEntity retrieve(String id) {
    return (PaymentIntentEntity) request(
      "PaymentIntentEntity",
      "GET",
      URI + "/" + id,
      null,
      false
    );
  }
}
