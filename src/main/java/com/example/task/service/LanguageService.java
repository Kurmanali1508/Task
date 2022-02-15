package com.example.task.service;

import com.example.task.entity.Language;

import java.util.List;

public interface LanguageService {
    Language getById(Long id);
    List<Language> getAll();
}