package main.java.com.paymongo.services;

import main.java.com.paymongo.entities.PaymentIntentEntity;

public class PaymentIntent extends BaseService {

  public static final String URI = "payment_intents";

  public static PaymentIntentEntity create(Object payload) {
    return (PaymentIntentEntity) request(
        "PaymentIntentEntity",
        "POST",
        URI,
        payload);
  }

  public static PaymentIntentEntity retrieve(String id) {
    return (PaymentIntentEntity) request(
        "PaymentIntentEntity",
        "GET",
        URI + "/" + id,
        null);
  }
}
