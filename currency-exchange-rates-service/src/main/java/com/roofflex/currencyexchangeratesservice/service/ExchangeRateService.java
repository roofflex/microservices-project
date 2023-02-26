package com.roofflex.currencyexchangeratesservice.service;

import com.roofflex.currencyexchangeratesservice.model.ExchangeRate;
import org.springframework.lang.NonNull;

/**
 * Service to perform operations with {@link ExchangeRate}
 */
public interface ExchangeRateService {

    @NonNull
    ExchangeRate findByFromAndTo(@NonNull String from, @NonNull String to);
}
