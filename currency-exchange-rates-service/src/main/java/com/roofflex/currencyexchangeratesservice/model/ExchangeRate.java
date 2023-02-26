package com.roofflex.currencyexchangeratesservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * Exchange rate between 2 currencies model
 */
@Entity
@Table(name = "exchange_rate")
@Getter
@Builder
@ToString
@NoArgsConstructor  // for JPA proxies
@AllArgsConstructor // for builder
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //fixme create a Currency enum
    @Column(name = "from_currency")
    private String from;

    @Column(name = "to_currency")
    private String to;

    @Column(name = "rate")
    private BigDecimal exchangeRate;

    @Column(name = "environment")
    private String environment;

}
