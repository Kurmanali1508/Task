package com.example.task.service.impl;

import com.example.task.entity.Product;
import com.example.task.repository.ProductClientResourceRepository;
import com.example.task.service.ProductClientResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DefaultProductClientResourceService implements ProductClientResourceService {
    private final ProductClientResourceRepository productClientResourceRepository;

    @Autowired
    public DefaultProductClientResourceService(ProductClientResourceRepository productClientResourceRepository) {
        this.productClientResourceRepository = productClientResourceRepository;
    }

    @Override
    public List<Product> getProductByNameOrDescription(String name, String description) {
        return productClientResourceRepository.findAllByNameOrDescription(name, description);
    }

    @Override
    public List<Product> getAllProductsByLanguageAndCurrency(Long languageId, Long currencyId) {
        return productClientResourceRepository.findAllByLanguage_IdAndCurrency_Id(languageId, currencyId);
    }

    @Override
    public List<Product> getAllProductsByLanguageOrCurrency(Long languageId, Long currencyId) {
        return productClientResourceRepository.findAllByLanguage_IdOrCurrency_Id(languageId, currencyId);
    }

    @Override
    public Product getById(Long id) {
        return productClientResourceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product with id " + id + " is not found!"));
    }
}