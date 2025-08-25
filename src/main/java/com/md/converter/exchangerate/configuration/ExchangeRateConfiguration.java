package com.md.converter.exchangerate.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ExchangeRateConfiguration {

  @Bean
  public RestClient exchangeRateClient() {
    return RestClient.create();
  }
}
