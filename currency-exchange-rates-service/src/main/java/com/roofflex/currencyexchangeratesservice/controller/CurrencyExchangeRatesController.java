package com.roofflex.currencyexchangeratesservice.controller;

import com.roofflex.currencyexchangeratesservice.model.ExchangeRate;
import com.roofflex.currencyexchangeratesservice.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeRatesController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping("/currency-exchange-rate")
    public ResponseEntity<ExchangeRate> getExchangeRate(@RequestParam String from, @RequestParam String to) {
        ExchangeRate exchangeRate = exchangeRateService.findByFromAndTo(from, to);

        return ResponseEntity.ok()
                .body(exchangeRate);
    }
}
