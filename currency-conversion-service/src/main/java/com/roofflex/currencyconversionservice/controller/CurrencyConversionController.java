package com.roofflex.currencyconversionservice.controller;

import com.roofflex.currencyconversionservice.model.CurrencyConversion;
import com.roofflex.currencyconversionservice.model.ExchangeRateDto;
import com.roofflex.currencyconversionservice.restclient.CurrencyExchangeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import static java.util.Objects.requireNonNull;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    @GetMapping("/currency-conversion")
    public CurrencyConversion calculateCurrencyConversion(@RequestParam String from,
                                                          @RequestParam String to,
                                                          @RequestParam BigDecimal quantity) {
        ResponseEntity<ExchangeRateDto> responseEntity = currencyExchangeServiceProxy.getExchangeRate(from, to);

        ExchangeRateDto exchangeRateDto = requireNonNull(responseEntity.getBody(), "expected non-null exchange rate");


        return CurrencyConversion.builder()
                .id(101L)
                .from(exchangeRateDto.from())
                .to(exchangeRateDto.to())
                .quantity(quantity)
                .exchangeRate(exchangeRateDto.exchangeRate())
                .totalCalculatedAmount(quantity.multiply(exchangeRateDto.exchangeRate()))
                .environment(exchangeRateDto.environment())
                .build();
    }
}
