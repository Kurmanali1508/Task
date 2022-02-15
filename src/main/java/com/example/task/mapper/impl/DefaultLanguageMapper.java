package com.example.task.mapper.impl;

import com.example.task.dto.LanguageDto;
import com.example.task.entity.Language;
import com.example.task.mapper.LanguageMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultLanguageMapper implements LanguageMapper {
    @Override
    public LanguageDto toLanguageDto(Language language) {
        LanguageDto languageDto = new LanguageDto();

        languageDto.setId(language.getId());
        languageDto.setLanguage(language.getLanguage());

        return languageDto;
    }
}