package com.md.converter.exchangerate.client;

import com.md.converter.exchangerate.client.dto.ExchangeRateResponseDTO;

public interface ExchangeRateClient {

  ExchangeRateResponseDTO getCurrencyInfo(String currency);
}
