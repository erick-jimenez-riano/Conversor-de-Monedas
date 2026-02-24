package com.erick.currency.ui;

import com.erick.currency.application.service.CurrencyConverterService;
import com.erick.currency.infrastructure.api.ExchangeRateApiClient;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        var apiClient = new ExchangeRateApiClient();
        var service = new CurrencyConverterService(apiClient);

        boolean running = true;

        while (running) {

            System.out.println("\n=== CONVERSOR DE MONEDAS ===");
            System.out.println("1. Convertir moneda");
            System.out.println("2. Salir");
            System.out.print("Seleccione opción: ");

            int option = scanner.nextInt();
            System.out.println("Monedas disponibles:");
            try {
                System.out.println(apiClient.getAvailableCurrencies("USD"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


            switch (option) {

                case 1 -> {
                    System.out.print("Moneda origen: ");
                    String from = scanner.next().toUpperCase();

                    System.out.print("Moneda destino: ");
                    String to = scanner.next().toUpperCase();

                    System.out.print("Cantidad: ");
                    double amount = scanner.nextDouble();

                    try {
                        var conversion = service.convert(from, to, amount);
                        System.out.println("Resultado: " + conversion.getResult());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                case 2 -> running = false;

                default -> System.out.println("Opción inválida");
            }
        }

        scanner.close();
    }
}