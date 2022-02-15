package com.example.task.service;

import com.example.task.entity.Product;

import java.util.List;

public interface ProductClientResourceService {
   List<Product> getProductByNameOrDescription(String name, String description);
   List<Product> getAllProductsByLanguageAndCurrency(Long languageId, Long currencyId);
   List<Product> getAllProductsByLanguageOrCurrency(Long languageId, Long currencyId);
   Product getById(Long id);
}