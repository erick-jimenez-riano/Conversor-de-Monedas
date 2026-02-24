package com.erick.currency.domain.model;

public class CurrencyConversion {

    private final String from;
    private final String to;
    private final double amount;
    private final double result;

    public CurrencyConversion(String from, String to, double amount, double result) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.result = result;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getAmount() {
        return amount;
    }

    public double getResult() {
        return result;
    }
}