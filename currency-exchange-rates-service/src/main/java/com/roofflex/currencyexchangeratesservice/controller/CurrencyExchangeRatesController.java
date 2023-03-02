package com.roofflex.currencyexchangeratesservice.controller;

import com.roofflex.currencyexchangeratesservice.model.ExchangeRate;
import com.roofflex.currencyexchangeratesservice.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@RestController
public class CurrencyExchangeRatesController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping("/currency-exchange-rate")
    public ResponseEntity<ExchangeRate> getExchangeRate(@RequestParam String from, @RequestParam String to) {
        ExchangeRate fetched = exchangeRateService.findByFromAndTo(from, to);

        String port = environment.getProperty("local.server.port");

        ExchangeRate exchangeRate = ExchangeRate.builder()
                .id(fetched.getId())
                .from(fetched.getFrom())
                .to(fetched.getTo())
                .exchangeRate(fetched.getExchangeRate())
                .environment(MessageFormat.format("port {0}", port))
                .build();

        return ResponseEntity.ok()
                .body(exchangeRate);
    }
}
