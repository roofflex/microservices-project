package com.roofflex.currencyexchangeratesservice.repository;

import com.roofflex.currencyexchangeratesservice.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository to perform DB operations with {@link ExchangeRate}
 */
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

    ExchangeRate findByFromAndTo(String from, String to);
}
