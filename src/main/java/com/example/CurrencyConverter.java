package com.example;

import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CurrencyConverterService service = new CurrencyConverterService();

        while (true) {
            System.out.println("Bem vindo(a) ao Conversor de Moedas: ");
            System.out.println("1.Converter moeda: ");
            System.out.println("2.Sair: ");
            System.out.print("Escolher opção: ");
            int op = sc.nextInt();

            if (op == 1) {
                System.out.println("Digite a moeda de Origem (ex:USD): ");
                String fromCurrency = sc.next();
                System.out.println("Digite a moeda de Destino (ex:EUR): ");
                String toCurrency = sc.next();
                System.out.println("Digite a quantidade: ");
                int quantidade = sc.nextInt();

                double convertedAmount = service.convertCurrency(fromCurrency, toCurrency, quantidade);
                System.out.println("Convertida com sucesso: " + convertedAmount);
            } else if (op == 2) {
                System.out.println("Sair: ");
                System.exit(0);
                break;
            } else {
                System.out.println("opção invalida!Tente novamente!");
            }
        }
        sc.close();
    }
}
