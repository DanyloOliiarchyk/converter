package com.md.converter.exchangerate.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "exchanges")
public class ExchangeRateClientConfiguration {

  private String baseUrl = "https://open.er-api.com/v6/latest";
}
