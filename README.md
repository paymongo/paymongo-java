# PayMongo Java Library
PayMongo Java library provides java applications an easy access to the PayMongo API. Explore various classes that can represent API resources on object instantiation. The goal of this library is simplify PayMongo integration with any java application.

## Pending TODOs

- Unit Tests

## Documentation

See the [PayMongo API docs](https://developers.paymongo.com/reference/getting-started-with-your-api).

### Requirements

- Java 1.8 or later

### Gradle users

Add this dependency to your project's build file:
 - TBD

### Maven users

Add this dependency to your project's POM:
 - TBD

### Others

You'll need to manually install the following JARs:

- [The PayMongo JAR]<link>

## Usage

The library needs to be configured with your account's secret key which is
available in your [PayMongo Dashboard][api-keys]. Initialize the library to its
value:

PaymongoExample.java

```java
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.paymongo.Paymongo;
import com.paymongo.services.PaymentIntent;

public class PaymongoExample {
  public static void main(String[] args) {
    // Set api key config
    Paymongo.api_key = "sk_...";

    // Payment Method
    var payment_method = PaymentMethod.retrieve("pm_...");

    // Retrieve attributes
    System.out.println(payment_method.id);
    System.out.println(payment_method.type);

    Map<String, Object> params = new HashMap<>();
    params.put("email", "test@paymongo.com");
    params.put("name", "Pay Mongo");
    params.put("phone", "09123456789");
    params.put("type", "gcash");

    PaymentMethod.create(params);

    // Payment Intent
    var payment_intent = PaymentIntent.retrieve("pi_...");

    Map<String, Object> params = new HashMap<>();
    params.put("amount", 10000);
    params.put("currency", "PHP");
    params.put("description", "Dog Treat");
    params.put("payment_method_allowed", Arrays.asList("gcash"));

    PaymentIntent.create(params);

    Map<String, Object> params = new HashMap<>();
    params.put("payment_method", "pi_...");
    params.put("return_url", "https://test/success");

    PaymentIntent.attach("pi_...", params);

    PaymentIntent.cancel("pi_...");

    Map<String, Object> params = new HashMap<>();
    params.put("amount", payment_intent.amount);

    PaymentIntent.capture("pi_...", params);

    // Payment
    PaymentMethod.retrieve("pay_...");

    // Refund
    Refund.retrieve("ref_...");

    Map<String, Object> params = new HashMap<>();
    params.put("amount", 10000);
    params.put("payment_id", "pay_...");
    params.put("reason", "requested_by_customer");

    Refund.create(params);
  }
}

```

```java
// Links
Link.retrieve("link_...");

Link.archive("link_...");

Link.unarchive("link_...");

Map<String, Object> params = new HashMap<>();
params.put("amount", 10000);
params.put("description", "link description");
params.put("remarks", "link remarks");

Link.create(params);

Map<String, Object> params = new HashMap<>();
params.put("reference_number", "1234abc");

Link.all(params);
```
