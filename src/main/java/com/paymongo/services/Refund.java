package com.paymongo.services;

import com.paymongo.entities.RefundEntity;

public class Refund extends BaseService {
  public static final String URI = "refunds";

  public static RefundEntity create(Object payload) {
    return (RefundEntity) request(
      "RefundEntity",
      "POST",
      URI,
      payload,
      false
    );
  }

  public static RefundEntity retrieve(String id) {
    return (RefundEntity) request(
      "RefundEntity",
      "GET",
      URI + "/" + id,
      null,
      false
    );
  }
}
