package com.example.task.mapper;

import com.example.task.dto.LanguageDto;
import com.example.task.entity.Language;

public interface LanguageMapper {
    LanguageDto toLanguageDto(Language language);
}