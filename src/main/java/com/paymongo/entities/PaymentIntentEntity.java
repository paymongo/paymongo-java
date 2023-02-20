package main.java.com.paymongo.entities;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentIntentEntity {
	public String id;
	public int amount;
	public String capture_type;
	public String client_key;
	public String currency;
	public String description;
	public Boolean livemode;
	public String statement_descriptor;
	public String status;
	public String last_payment_error;
	public Object payment_method;
	public Object payment_method_allowed;
	public Object payments;
	public Object next_action;
	public Object payment_method_options;
	public String metadata;
	public String setup_future_usage;
	public int created_at;
	public int updated_at;

	@JsonProperty("attributes")
	private void unpackNested(Map<String, Object> attributes) {
		this.amount = (int) attributes.get("amount");
		this.capture_type = (String) attributes.get("capture_type");
		this.client_key = (String) attributes.get("client_key");
		this.currency = (String) attributes.get("currency");
		this.description = (String) attributes.get("description");
		this.livemode = (Boolean) attributes.get("livemode");
		this.statement_descriptor = (String) attributes.get("statement_descriptor");
		this.status = (String) attributes.get("status");
		this.last_payment_error = (String) attributes.get("last_payment_error");
		this.payment_method = (Object) attributes.get("payment_method");
		this.payment_method_allowed = (Object) attributes.get("payment_method_allowed");
		this.payments = (Object) attributes.get("payments");
		this.next_action = attributes.get("next_action");
		this.payment_method_options = attributes.get("payment_method_options");
		this.metadata = (String) attributes.get("metadata");
		this.setup_future_usage = (String) attributes.get("capsetup_future_usageture_type");
		this.created_at = (int) attributes.get("created_at");
		this.updated_at = (int) attributes.get("updated_at");
	}
}
