package com.roofflex.currencyexchangeratesservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * Exchange rate between 2 currencies model
 */
@Getter
@Builder
@ToString
@NoArgsConstructor  // for JPA proxies
@AllArgsConstructor // for builder
public class ExchangeRate {

    private Long id;
    //fixme create a Currency enum
    private String from;
    private String to;
    private BigDecimal exchangeRate;
    private String environment;

}
