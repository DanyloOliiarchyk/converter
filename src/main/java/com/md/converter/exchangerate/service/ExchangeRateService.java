package com.md.converter.exchangerate.service;

import java.math.BigDecimal;

public interface ExchangeRateService {

  BigDecimal exchange(String currency, BigDecimal value, String to);
}
