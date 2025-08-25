package com.md.converter.exchangerate.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConverterResponseDTO {

  private BigDecimal value;
  private String currency;
}
