package com.md.converter.exchangerate.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ConverterResponseDTO {

    private BigDecimal value;
    private String currency;
}
