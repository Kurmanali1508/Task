package com.example.task.service;

import com.example.task.entity.Product;

import java.util.List;

public interface ProductService {
    Product getById(Long id);
    List<Product> getAll();
    Product save(Product product);
    void deleteById(Long id);
}
