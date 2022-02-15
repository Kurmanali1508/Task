package com.example.task.mapper.impl;

import com.example.task.dto.CurrencyDto;
import com.example.task.entity.Currency;
import com.example.task.mapper.CurrencyMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultCurrencyMapper implements CurrencyMapper {
    @Override
    public CurrencyDto toCurrencyDto(Currency currency) {
        CurrencyDto currencyDto = new CurrencyDto();

        currencyDto.setId(currency.getId());
        currencyDto.setCurrency(currency.getCurrency());

        return currencyDto;
    }
}