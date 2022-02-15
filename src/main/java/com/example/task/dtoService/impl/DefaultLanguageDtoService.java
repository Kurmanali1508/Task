package com.example.task.dtoService.impl;

import com.example.task.dto.LanguageDto;
import com.example.task.dtoService.LanguageDtoService;
import com.example.task.mapper.LanguageMapper;
import com.example.task.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultLanguageDtoService implements LanguageDtoService {
    private final LanguageService languageService;
    private final LanguageMapper languageMapper;

    @Autowired
    public DefaultLanguageDtoService(LanguageService languageService, LanguageMapper languageMapper) {
        this.languageService = languageService;
        this.languageMapper = languageMapper;
    }

    @Override
    public List<LanguageDto> getAll() {
        return languageService.getAll()
                .stream()
                .map(languageMapper::toLanguageDto)
                .collect(Collectors.toList());
    }
}