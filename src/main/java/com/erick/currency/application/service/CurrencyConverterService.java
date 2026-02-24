package com.erick.currency.application.service;

import com.erick.currency.domain.model.CurrencyConversion;
import com.erick.currency.domain.port.ExchangeRatePort;

public class CurrencyConverterService {

    private final ExchangeRatePort exchangeRatePort;

    public CurrencyConverterService(ExchangeRatePort exchangeRatePort) {
        this.exchangeRatePort = exchangeRatePort;
    }

    public CurrencyConversion convert(String from, String to, double amount)
            throws Exception {

        double rate = exchangeRatePort.getRate(from, to);
        double result = amount * rate;

        return new CurrencyConversion(from, to, amount, result);
    }
}
