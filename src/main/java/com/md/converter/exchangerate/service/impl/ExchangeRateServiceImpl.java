package com.md.converter.exchangerate.service.impl;

import com.md.converter.exchangerate.client.ExchangeRateClient;
import com.md.converter.exchangerate.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final ExchangeRateClient client;

    @Override
    public BigDecimal exchange(String currency, BigDecimal value, String to) {
        var response = client.getCurrencyInfo(currency);
        var rate = response.getRates().get(to);
        return value.multiply(rate).setScale(2, RoundingMode.HALF_UP);
    }
}
