package com.example.task.repository;

import com.example.task.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductClientResourceRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByNameOrDescription(String name, String description);
    List<Product> findAllByLanguage_IdAndCurrency_Id(Long languageId, Long currencyId);
    List<Product> findAllByLanguage_IdOrCurrency_Id(Long languageId, Long currencyId);
}