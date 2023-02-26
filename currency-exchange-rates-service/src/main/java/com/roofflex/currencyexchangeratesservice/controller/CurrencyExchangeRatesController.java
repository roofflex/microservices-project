package com.roofflex.currencyexchangeratesservice.controller;

import com.roofflex.currencyexchangeratesservice.model.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1")
public class CurrencyExchangeRatesController {

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange-rate")
    public ResponseEntity<ExchangeRate> getExchangeRate(@RequestParam String from, @RequestParam String to) {
        ExchangeRate exchangeRate = ExchangeRate.builder()
                .id(1001L)
                .from(from)
                .to(to)
                .exchangeRate(BigDecimal.valueOf(0.93d))
                .environment(environment.getProperty("local.server.port"))
                .build();

        return ResponseEntity.ok()
                .body(exchangeRate);
    }
}
