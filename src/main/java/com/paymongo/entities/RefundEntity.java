package com.paymongo.entities;

import java.util.Map;

public class RefundEntity {
  public String id;
  public int amount;
  public String balance_transaction_id;
  public String currency;
  public Boolean livemode;
  public Object metadata;
  public String notes;
  public String payment_id;
  public String payout_id;
  public String reason;
  public String status;
  public int available_at;
  public int created_at;
  public Integer refunded_at;
  public int updated_at;

  public RefundEntity(Map<String, Object> data) {
    var attributes = (Map<String, Object>) data.get("attributes");

    this.id = (String) data.get("id");
    this.amount = (int) attributes.get("amount");
    this.balance_transaction_id = (String) attributes.get("balance_transaction_id");
    this.currency = (String) attributes.get("currency");
    this.livemode = (Boolean) attributes.get("livemode");
    this.metadata = attributes.get("metadata");
    this.notes = (String) attributes.get("notes");
    this.payment_id = (String) attributes.get("payment_id");
    this.payout_id = (String) attributes.get("payout_id");
    this.reason = (String) attributes.get("reason");
    this.status = (String) attributes.get("status");
    this.available_at = (int) attributes.get("available_at");
    this.created_at = (int) attributes.get("created_at");
    this.refunded_at = (Integer) attributes.get("refunded_at");
    this.updated_at = (int) attributes.get("updated_at");
  }
}
