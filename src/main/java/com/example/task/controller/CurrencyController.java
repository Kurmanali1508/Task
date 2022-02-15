package com.example.task.controller;

import com.example.task.dto.CurrencyDto;
import com.example.task.dtoService.CurrencyDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    private final CurrencyDtoService currencyDtoService;

    @Autowired
    public CurrencyController(CurrencyDtoService currencyDtoService) {
        this.currencyDtoService = currencyDtoService;
    }

    @GetMapping
    public List<CurrencyDto> getAll() {
        return currencyDtoService.getAll();
    }
}