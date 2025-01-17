package com.example;

// Importando classes necessárias
import java.util.Optional;

public class CurrencyConverterService {
    private final CurrencyConverterAPI api = new CurrencyConverterAPI();

    public double convert(String from, String to, double amount) {
        // conseguindo exchange rate da  API
        Optional<Double> exchangeRateOpt = api.getExchangeRate(from, to);

        // Usar Optional para lida com o  case onde a exchange rate não esteja presente
        return exchangeRateOpt
                .map(exchangeRate -> exchangeRate * amount) // Multiply if present
                .orElseGet(() -> {
                    System.err.println("Erro: Conversão não disponível: " + from + " para " + to);
                    return 0.0; // Return 0 or handle it as needed
                });
    }

    public double convertCurrency(String fromCurrency, String toCurrency, double quantity) {
        // You can implement this method similarly or use it for a different purpose
        return convert(fromCurrency, toCurrency, quantity);
    }
}

