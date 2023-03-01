package com.roofflex.currencyconversionservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * Model for currency conversion response
 */
@Getter
@Builder
@ToString
@AllArgsConstructor // for builder
public class CurrencyConversion {

    private Long id;
    private String from;
    private String to;
    private BigDecimal quantity;
    private BigDecimal exchangeRate;
    private BigDecimal totalAmount;
    private String environment;
}
