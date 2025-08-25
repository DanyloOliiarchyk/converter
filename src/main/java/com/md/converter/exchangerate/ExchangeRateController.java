package com.md.converter.exchangerate;

import com.md.converter.exchangerate.dto.ConverterResponseDTO;
import com.md.converter.exchangerate.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/converter")
public class ExchangeRateController {

    private final ExchangeRateService service;

    @GetMapping
    public ConverterResponseDTO exchange(
            @RequestParam("value") final BigDecimal value,
            @RequestParam("currency") final String currency,
            @RequestParam("exchange-to") final String to) {
        var exchanged = service.exchange(currency, value, to);
        return ConverterResponseDTO.builder()
                .currency(to)
                .value(exchanged)
                .build();
    }
}
