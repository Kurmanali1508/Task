package com.example.task.mapper.impl;

import com.example.task.dto.ProductDto;
import com.example.task.entity.Product;
import com.example.task.mapper.CurrencyMapper;
import com.example.task.mapper.LanguageMapper;
import com.example.task.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultProductMapper implements ProductMapper {
    private final LanguageMapper languageMapper;
    private final CurrencyMapper currencyMapper;

    @Autowired
    public DefaultProductMapper(LanguageMapper languageMapper, CurrencyMapper currencyMapper) {
        this.languageMapper = languageMapper;
        this.currencyMapper = currencyMapper;
    }

    @Override
    public ProductDto toProductDto(Product product) {
        ProductDto productDto = new ProductDto();

        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setCreationDate(product.getCreationDate());
        productDto.setModificationDate(product.getModificationDate());

        if (product.getLanguage() != null) {
            productDto.setLanguageDto(languageMapper.toLanguageDto(product.getLanguage()));
        }

        if (product.getCurrency() != null) {
            productDto.setCurrencyDto(currencyMapper.toCurrencyDto(product.getCurrency()));
        }

        return productDto;
    }
}