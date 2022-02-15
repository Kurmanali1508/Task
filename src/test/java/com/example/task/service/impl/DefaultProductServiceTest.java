package com.example.task.service.impl;

import com.example.task.entity.Product;
import com.example.task.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class DefaultProductServiceTest {
    @InjectMocks
    private DefaultProductService defaultProductService;

    @Mock
    private ProductRepository productRepository;

    private Product product;
    private BigDecimal price;
    private Date date;
    private String name;
    private String description;

    @BeforeEach
    void setUp() {
        defaultProductService = new DefaultProductService(productRepository);

        price = new BigDecimal(777);

        date = new Date();

        name = "some name";

        description = "description";

        product = new Product();
        product.setId(1L);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setCreationDate(date);
        product.setModificationDate(date);
    }

    @AfterEach
    void tearDown() {
        product = null;
        date = null;
        price = null;
        name = null;
        description = null;
    }

    @Test
    void getById_withValidId_shouldReturnProduct() {
        when(productRepository.findById(1L)).thenReturn(Optional.ofNullable(product));

        Product responseProduct = defaultProductService.getById(1L);

        assertEquals(1L, responseProduct.getId());
        assertEquals(name, responseProduct.getName());
        assertEquals(description, responseProduct.getDescription());
        assertEquals(price, responseProduct.getPrice());
        assertEquals(date, responseProduct.getCreationDate());
        assertEquals(date, responseProduct.getModificationDate());

        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    void getAll_withValidData_shouldReturnProductList() {
        when(productRepository.findAll()).thenReturn(Collections.singletonList(product));

        List<Product> products = defaultProductService.getAll();

        assertThat(products).hasSize(1);
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void save_withValidData_shouldReturnProduct() {
        when(productRepository.save(any())).thenReturn(product);

        Product responseProduct = defaultProductService.save(product);

        assertEquals(1L, responseProduct.getId());
        assertEquals(name, responseProduct.getName());
        assertEquals(description, responseProduct.getDescription());
        assertEquals(price, responseProduct.getPrice());
        assertEquals(date, responseProduct.getCreationDate());
        assertEquals(date, responseProduct.getModificationDate());

        verify(productRepository, times(1)).save(any());
    }
}