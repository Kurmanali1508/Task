package com.example.task.dtoService;

import com.example.task.dto.CreateProductDto;
import com.example.task.dto.ProductDto;
import com.example.task.dto.UpdateProductDto;

import java.util.List;

public interface ProductDtoService {
    ProductDto getById(Long id);
    List<ProductDto> getAll();
    ProductDto create(CreateProductDto createProductDto);
    ProductDto update(Long id, UpdateProductDto updateProductDto);
    void deleteById(Long id);
}