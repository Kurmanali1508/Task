package com.example.task.controller;

import com.example.task.dto.CreateProductDto;
import com.example.task.dto.ProductDto;
import com.example.task.dto.UpdateProductDto;
import com.example.task.dtoService.ProductDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
@Validated
public class ProductController {
    private final ProductDtoService productDtoService;

    @Autowired
    public ProductController(ProductDtoService productDtoService) {
        this.productDtoService = productDtoService;
    }

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable("id") Long id) {
        return productDtoService.getById(id);
    }

    @GetMapping
    public List<ProductDto> getAll() {
        return productDtoService.getAll();
    }

    @PostMapping
    public ProductDto create(@Valid @RequestBody CreateProductDto createProductDto) {
        return productDtoService.create(createProductDto);
    }

    @PutMapping("/{productId}")
    public ProductDto update(@PathVariable("productId") Long id, @RequestBody UpdateProductDto updateProductDto) {
        return productDtoService.update(id, updateProductDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        productDtoService.deleteById(id);
    }
}