package com.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

public class CurrencyConverterAPI {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/b33f2cf1fa10f64bac89a14f/latest/USD";

    public Optional<Double> getExchangeRate(String from, String to) {
        if (from == null || to == null || from.isEmpty() || to.isEmpty()) {
            throw new IllegalArgumentException("Os códigos de moeda não devem ser nulos ou vazios");
        }

        try {
            URL url = new URL(API_URL + from);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Check the response code
            int responseCode = conn.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.err.println("Erro: HTTP recebido " + responseCode);
                return Optional.empty();
            }

            // Use try-with-resources to ensure BufferedReader is closed
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                // Parse the JSON response
                JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();
                JsonObject rates = jsonResponse.getAsJsonObject("taxas");

                // Check if the target currency exists in the rates
                if (rates.has(to)) {
                    return Optional.of(rates.get(to).getAsDouble());
                } else {
                    System.err.println("Erro: Currency " + to + " resposta não encontrada");
                    return Optional.empty();
                }
            }

        } catch (Exception e) {
            System.err.println("Error fetching exchange rate: " + e.getMessage());
            return Optional.empty();
        }
    }
}