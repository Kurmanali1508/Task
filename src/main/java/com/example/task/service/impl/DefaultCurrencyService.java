package com.example.task.service.impl;

import com.example.task.entity.Currency;
import com.example.task.repository.CurrencyRepository;
import com.example.task.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DefaultCurrencyService implements CurrencyService {
    private final CurrencyRepository currencyRepository;

    @Autowired
    public DefaultCurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public Currency getById(Long id) {
        return currencyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Currency with id " + id + " is not found!"));
    }

    @Override
    public List<Currency> getAll() {
        return currencyRepository.findAll();
    }
}