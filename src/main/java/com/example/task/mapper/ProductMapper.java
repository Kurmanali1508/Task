package com.example.task.mapper;

import com.example.task.dto.ProductDto;
import com.example.task.entity.Product;

public interface ProductMapper {
    ProductDto toProductDto(Product product);
}