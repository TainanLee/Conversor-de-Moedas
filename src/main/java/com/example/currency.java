package com.example;

import java.util.Scanner;

class ConversorDeMoedasImpl extends ConversorDeMoedas {

    private static int opcao;

    double valor;

    public void ConversordDeMoedas(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu de Conversão de Moedas:");
            System.out.println("1. USD para EUR");
            System.out.println("2. USD para BRL");
            System.out.println("3. EUR para USD");
            System.out.println("4. BRL para USD");
            System.out.println("5. GBP para USD");
            System.out.println("6. JPY para USD");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            if (opcao >= 1 && opcao <= 6) {
                System.out.print("Digite o valor a ser convertido: ");

                ConversorDeMoedasImpl conversorDeMoedas = this;
                if (scanner.hasNextDouble()) {
                    conversorDeMoedas.valor = scanner.nextDouble();

                    Object taxa = obterTaxaDeCambio(opcao);
                    if (taxa != null) {
                        double resultado = this.valor * (Double) taxa;
                        System.out.println("Erro: Taxa de cambio não é um número válido  " + resultado);
                    }
                } else {
                    System.out.println("Erro: Valor inválido, por favor inserir um número");
                }
                String next = scanner.next();
            } else if (opcao != 0) {
                System.out.println("Tente novamente, opção inválida");
            }
        }while (opcao != 0);

    }

    private Object obterTaxaDeCambio(int opcao) {
        return null;
    }
}
        