package com.erick.currency.infrastructure.api;

import com.erick.currency.domain.port.ExchangeRatePort;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Set;

public class ExchangeRateApiClient implements ExchangeRatePort {

    private final String apiKey;
    private final HttpClient client;
    private final Gson gson;

    public ExchangeRateApiClient() {
        this.apiKey = System.getenv("EXCHANGE_API_KEY");

        if (apiKey == null) {
            throw new RuntimeException("API KEY no configurada.");
        }

        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }
    public Set<String> getAvailableCurrencies(String base) throws Exception {

        String url = "https://v6.exchangerate-api.com/v6/"
                + apiKey + "/latest/" + base;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        Map<?, ?> json = gson.fromJson(response.body(), Map.class);

        Map<String, Double> rates =
                (Map<String, Double>) json.get("conversion_rates");

        return rates.keySet();
    }

    @Override
    public double getRate(String from, String to) throws Exception {

        String url = "https://v6.exchangerate-api.com/v6/"
                + apiKey + "/latest/" + from;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        Map<?, ?> json = gson.fromJson(response.body(), Map.class);

        Map<String, Double> rates =
                (Map<String, Double>) json.get("conversion_rates");

        if (!rates.containsKey(to)) {
            throw new RuntimeException("Moneda no encontrada");
        }

        return rates.get(to);
    }
}
