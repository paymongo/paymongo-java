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

import main.java.com.paymongo.Paymongo;
import main.java.com.paymongo.services.PaymentIntent;

public class PaymongoExample {
  public static void main(String[] args) {

    // Set api key config
    Paymongo.api_key = "sk_...";

    // Payment Intent
    var payment_intent =  PaymentIntent.retrieve("pi_...");

    // Retrieve attributes
    System.out.println(payment_intent.id);
    => "pi_..."

    String params = "{\"amount\":10000, \"currency\":\"PHP\",\"description\":\"Dog Treat\", \"payment_method_allowed\":[ \"gcash\"]}";
    PaymentIntent.create(params);
  }
}

```
