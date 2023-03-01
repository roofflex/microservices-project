package com.roofflex.currencyconversionservice.model;

import java.math.BigDecimal;

public record ExchangeRateDto(Long id, String from, String to, BigDecimal exchangeRate, String environment) {
}
