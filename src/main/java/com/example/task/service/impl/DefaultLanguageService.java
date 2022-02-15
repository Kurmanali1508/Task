package com.example.task.service.impl;

import com.example.task.entity.Language;
import com.example.task.repository.LanguageRepository;
import com.example.task.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DefaultLanguageService implements LanguageService {
    private final LanguageRepository languageRepository;

    @Autowired
    public DefaultLanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public Language getById(Long id) {
        return languageRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Language with id " + id + " is not found!"));
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.findAll();
    }
}