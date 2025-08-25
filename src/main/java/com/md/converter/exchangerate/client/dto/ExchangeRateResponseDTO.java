package com.md.converter.exchangerate.client.dto;

import java.math.BigDecimal;
import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExchangeRateResponseDTO {

  private String result;
  private String provider;
  private String documentation;
  private String terms_of_use;
  private Long time_last_update_unix;
  private String time_last_update_utc;
  private Long time_next_update_unix;
  private String time_next_update_utc;
  private Long time_eol_unix;
  private String base_code;
  private Map<String, BigDecimal> rates;
}
