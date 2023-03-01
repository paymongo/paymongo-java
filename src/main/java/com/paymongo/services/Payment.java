package com.paymongo.services;

import com.paymongo.entities.PaymentEntity;

public class Payment extends BaseService {
  public static final String URI = "payments";

  public static PaymentEntity retrieve(String id) {
    return (PaymentEntity) request(
      "PaymentEntity",
      "GET",
      URI + "/" + id,
      null
    );
  }
}
