package com.example.task.dtoService;

import com.example.task.dto.ProductDto;
import com.example.task.exceptions.ProductNotFound;

import java.util.List;

public interface ProductClientResourceDtoService {
    List<ProductDto> getAllProductsByNameOrDescriptions(String name, String description);
    List<ProductDto> getAllProductsByLanguageAndCurrency(Long languageId, Long currencyId);
    List<ProductDto> getAllProductsByLanguageOrCurrency(Long languageId, Long currencyId);
    ProductDto getById(Long id, Long languageId, Long currencyId) throws ProductNotFound;
}