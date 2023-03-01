package com.roofflex.currencyconversionservice.controller;

import com.roofflex.currencyconversionservice.model.CurrencyConversion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @GetMapping("/currency-conversion")
    public CurrencyConversion calculateCurrencyConversion(@RequestParam String from,
                                                          @RequestParam String to,
                                                          @RequestParam BigDecimal quantity)
    {
        return CurrencyConversion.builder()
                .id(101L)
                .from("EUR")
                .to("USD")
                .quantity(BigDecimal.ONE)
                .exchangeRate(BigDecimal.ONE)
                .totalAmount(BigDecimal.ONE)
                .environment("")
                .build();
    }
}
