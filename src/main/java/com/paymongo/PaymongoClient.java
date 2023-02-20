package main.java.com.paymongo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.util.Base64;

/**
 * PaymongoClient
 */
public class PaymongoClient {
  public static ApiResource execute_request(String method, String payload, String path)
      throws URISyntaxException, IOException, InterruptedException {

    String URI = String.format("%s/%s/%s", Paymongo.API_BASE_URL, Paymongo.API_VERSION, path);

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = build_request(method, payload, URI);
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    // parse JSON
    ObjectMapper mapper = new ObjectMapper();
    mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
    ApiResource mapped_response = mapper.readValue(response.body(), ApiResource.class);

    return mapped_response;
  }

  private static HttpRequest build_request(String method, String params, String uri) throws URISyntaxException {
    // By default HttpRequest request method is GET
    HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
        .uri(new URI(uri))
        .headers("Authorization", getBasicAuthenticationHeader(Paymongo.api_key));

    switch (method) {
      case "POST":
        String formatted_params = String.format("{ \"data\": { \"attributes\": %s } }", params);
        requestBuilder.POST(BodyPublishers.ofString(formatted_params));
        requestBuilder.header("Content-Type", "application/json");
    }

    HttpRequest request = requestBuilder.build();
    return request;
  }

  private static final String getBasicAuthenticationHeader(String apiKey) {
    return "Basic " + Base64.getEncoder().encodeToString(apiKey.getBytes());
  }
}
