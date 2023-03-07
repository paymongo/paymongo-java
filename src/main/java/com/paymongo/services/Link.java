package com.paymongo.services;

import com.paymongo.entities.LinkEntity;
import com.paymongo.entities.ListingEntity;

public class Link extends BaseService {
  public static final String URI = "links";

  public static ListingEntity all(Object payload) {
    return (ListingEntity) request(
      "LinkEntity",
      "GET",
      URI,
      payload,
      true
    );
  }

  public static LinkEntity archive(String id) {
    return (LinkEntity) request(
      "LinkEntity",
      "POST",
      URI + "/" + id + "/archive",
      null,
      false
    );
  }

  public static LinkEntity create(Object payload) {
    return (LinkEntity) request(
      "LinkEntity",
      "POST",
      URI,
      payload,
      false
    );
  }

  public static LinkEntity retrieve(String id) {
    return (LinkEntity) request(
      "LinkEntity",
      "GET",
      URI + "/" + id,
      null,
      false
    );
  }

  public static LinkEntity unarchive(String id) {
    return (LinkEntity) request(
      "LinkEntity",
      "POST",
      URI + "/" + id + "/unarchive",
      null,
      false
    );
  }
}
