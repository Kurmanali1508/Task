package com.example.task.service;

import com.example.task.entity.Currency;

import java.util.List;

public interface CurrencyService {
    Currency getById(Long id);
    List<Currency> getAll();
}