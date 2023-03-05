package com.roofflex.currencyexchangeratesservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

@Slf4j
@RestController
public class CircuitBreakerController {

    @GetMapping("/sample-api")
//    @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
    @CircuitBreaker(name = "sample-api", fallbackMethod = "hardcodedResponse")
//    @RateLimiter(name = "sample-api")
    @Bulkhead(name = "sample-api")
    public ResponseEntity<String> getSampleAPIResponse() {
        log.info(MessageFormat.format("Sample API call received, timestamp={0}", System.currentTimeMillis()));
        ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8080/dummy-url", String.class);
        return response;
    }

    public ResponseEntity<String> hardcodedResponse(Exception e) {
        return ResponseEntity.ok("Fallback response");
    }
}
