package com.example.task.dtoService.impl;

import com.example.task.dto.ProductDto;
import com.example.task.dtoService.ProductClientResourceDtoService;
import com.example.task.entity.Product;
import com.example.task.exceptions.ProductNotFound;
import com.example.task.mapper.ProductMapper;
import com.example.task.service.ProductClientResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultProductClientResourceDtoService implements ProductClientResourceDtoService {
    private final ProductClientResourceService productClientResourceService;
    private final ProductMapper productMapper;

    @Autowired
    public DefaultProductClientResourceDtoService(ProductClientResourceService productClientResourceService, ProductMapper productMapper) {
        this.productClientResourceService = productClientResourceService;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> getAllProductsByNameOrDescriptions(String name, String description) {
        return productClientResourceService.getProductByNameOrDescription(name, description)
                .stream()
                .map(productMapper::toProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getAllProductsByLanguageAndCurrency(Long languageId, Long currencyId) {
        return productClientResourceService.getAllProductsByLanguageAndCurrency(languageId, currencyId)
                .stream()
                .map(productMapper::toProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getAllProductsByLanguageOrCurrency(Long languageId, Long currencyId) {
        return productClientResourceService.getAllProductsByLanguageOrCurrency(languageId, currencyId)
                .stream()
                .map(productMapper::toProductDto)
                .collect(Collectors.toList());
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @Override
    public ProductDto getById(Long id, Long languageId, Long currencyId) throws ProductNotFound {
        Product product = productClientResourceService.getById(id);

        if (product.getLanguage().getId().equals(languageId) && product.getCurrency().getId().equals(currencyId)) {
            return productMapper.toProductDto(product);
        } else {
            throw new ProductNotFound("Product not found!");
        }
    }
}