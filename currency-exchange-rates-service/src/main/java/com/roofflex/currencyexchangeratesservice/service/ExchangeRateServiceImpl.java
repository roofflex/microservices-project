package com.roofflex.currencyexchangeratesservice.service;

import com.roofflex.currencyexchangeratesservice.model.ExchangeRate;
import com.roofflex.currencyexchangeratesservice.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    ExchangeRateRepository exchangeRateRepository;

    @NonNull
    @Override
    public ExchangeRate findByFromAndTo(@NonNull String from, @NonNull String to) {
        //fixme create ExchangeRateNotFoundException to throw when rate is null
        return exchangeRateRepository.findByFromAndTo(from, to);
    }
}
