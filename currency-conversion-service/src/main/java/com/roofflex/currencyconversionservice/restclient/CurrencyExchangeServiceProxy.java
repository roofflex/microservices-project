package com.roofflex.currencyconversionservice.restclient;

import com.roofflex.currencyconversionservice.model.ExchangeRateDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Proxy to currency-exchange-rates-service to ease requests to that service
 */
@FeignClient(name = "currency-exchange-rates-service", url = "localhost:8000/api/v1")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange-rate")
    ResponseEntity<ExchangeRateDto> getExchangeRate(@RequestParam String from, @RequestParam String to);
}
