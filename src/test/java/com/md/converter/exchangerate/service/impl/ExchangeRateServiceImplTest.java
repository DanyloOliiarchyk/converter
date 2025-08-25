package com.md.converter.exchangerate.service.impl;

import com.md.converter.exchangerate.client.ExchangeRateClient;
import com.md.converter.exchangerate.client.dto.ExchangeRateResponseDTO;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExchangeRateServiceImplTest {

    @Mock
    private ExchangeRateClient client;

    @InjectMocks
    private ExchangeRateServiceImpl unit;


    @ParameterizedTest
    @MethodSource("input")
    void exchangeTest(String currency, BigDecimal value, String to, BigDecimal rate, BigDecimal expected){
        var info = ExchangeRateResponseDTO.builder()
                .rates(Map.of(to, rate))
                .build();

        when(client.getCurrencyInfo(currency)).thenReturn(info);

        var actual = unit.exchange(currency, value, to);

        assertEquals(expected, actual);
        verify(client).getCurrencyInfo(currency);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of("USD", new BigDecimal(1000), "UAH", new BigDecimal(42), new BigDecimal("42000.00")),
                Arguments.of("UAH", new BigDecimal(420), "UAH", new BigDecimal("0.1"), new BigDecimal("42.00")),
                Arguments.of("EUR", new BigDecimal(1000), "UAH", new BigDecimal(45), new BigDecimal("45000.00"))
        );
    }

}