package com.md.converter.exchangerate.client.impl;

import com.md.converter.exchangerate.client.ExchangeRateClient;
import com.md.converter.exchangerate.client.dto.ExchangeRateResponseDTO;
import com.md.converter.exchangerate.configuration.ExchangeRateClientConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class ExchangeRateClientImpl implements ExchangeRateClient {

    private final RestClient exchangeRateClient;
    private final ExchangeRateClientConfiguration configuration;

    @Override
    public ExchangeRateResponseDTO getCurrencyInfo(String currency) {
        return exchangeRateClient.get()
                .uri(configuration.getBaseUrl() + "/" + currency)
                .retrieve()
                .body(ExchangeRateResponseDTO.class);
    }
}
