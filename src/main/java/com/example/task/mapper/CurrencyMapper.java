package com.example.task.mapper;

import com.example.task.dto.CurrencyDto;
import com.example.task.entity.Currency;

public interface CurrencyMapper {
    CurrencyDto toCurrencyDto(Currency currency);
}