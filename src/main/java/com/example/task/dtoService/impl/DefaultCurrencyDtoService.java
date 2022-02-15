package com.example.task.dtoService.impl;

import com.example.task.dto.CurrencyDto;
import com.example.task.dtoService.CurrencyDtoService;
import com.example.task.mapper.CurrencyMapper;
import com.example.task.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultCurrencyDtoService implements CurrencyDtoService {
    private final CurrencyService currencyService;
    private final CurrencyMapper currencyMapper;

    @Autowired
    public DefaultCurrencyDtoService(CurrencyService currencyService, CurrencyMapper currencyMapper) {
        this.currencyService = currencyService;
        this.currencyMapper = currencyMapper;
    }

    @Override
    public List<CurrencyDto> getAll() {
        return currencyService.getAll()
                .stream()
                .map(currencyMapper::toCurrencyDto)
                .collect(Collectors.toList());
    }
}