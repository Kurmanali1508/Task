package com.example.task.controller;

import com.example.task.dto.LanguageDto;
import com.example.task.dtoService.LanguageDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {
    private final LanguageDtoService languageDtoService;

    @Autowired
    public LanguageController(LanguageDtoService languageDtoService) {
        this.languageDtoService = languageDtoService;
    }

    @GetMapping
    public List<LanguageDto> getAll() {
        return languageDtoService.getAll();
    }
}