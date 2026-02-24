package com.erick.currency.domain.port;

public interface ExchangeRatePort {

    double getRate(String from, String to) throws Exception;
}
