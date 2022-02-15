package com.example.task.dtoService.impl;

import com.example.task.dto.CreateProductDto;
import com.example.task.dto.ProductDto;
import com.example.task.dto.UpdateProductDto;
import com.example.task.dtoService.ProductDtoService;
import com.example.task.entity.Product;
import com.example.task.mapper.ProductMapper;
import com.example.task.service.CurrencyService;
import com.example.task.service.LanguageService;
import com.example.task.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultProductDtoService implements ProductDtoService {
    private final ProductService productService;
    private final ProductMapper productMapper;
    private final LanguageService languageService;
    private final CurrencyService currencyService;

    @Autowired
    public DefaultProductDtoService(ProductService productService, ProductMapper productMapper, LanguageService languageService, CurrencyService currencyService) {
        this.productService = productService;
        this.productMapper = productMapper;
        this.languageService = languageService;
        this.currencyService = currencyService;
    }

    @Override
    public ProductDto getById(Long id) {
        Product product = productService.getById(id);

        return productMapper.toProductDto(product);
    }

    @Override
    public List<ProductDto> getAll() {
        return productService.getAll()
                .stream()
                .map(productMapper::toProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto create(CreateProductDto createProductDto) {
        Product product = new Product();

        product.setName(createProductDto.getName());
        product.setDescription(createProductDto.getDescription());
        product.setPrice(createProductDto.getPrice());
        product.setCreationDate(createProductDto.getCreationDate());
        product.setModificationDate(createProductDto.getModificationDate());
        product.setLanguage(languageService.getById(createProductDto.getLanguageId()));
        product.setCurrency(currencyService.getById(createProductDto.getCurrencyId()));

        return productMapper.toProductDto(productService.save(product));
    }

    @Override
    public ProductDto update(Long id, UpdateProductDto updateProductDto) {
        Product product = productService.getById(id);

        product.setName(updateProductDto.getName());
        product.setDescription(updateProductDto.getDescription());
        product.setPrice(updateProductDto.getPrice());
        product.setCreationDate(updateProductDto.getCreationDate());
        product.setModificationDate(updateProductDto.getModificationDate());
        product.setLanguage(languageService.getById(updateProductDto.getLanguageId()));
        product.setCurrency(currencyService.getById(updateProductDto.getCurrencyId()));

        return productMapper.toProductDto(productService.save(product));
    }

    @Override
    public void deleteById(Long id) {
        productService.deleteById(id);
    }
}