package com.example.task.dtoService.impl;

import com.example.task.dto.*;
import com.example.task.entity.Currency;
import com.example.task.entity.Language;
import com.example.task.entity.Product;
import com.example.task.mapper.ProductMapper;
import com.example.task.service.CurrencyService;
import com.example.task.service.LanguageService;
import com.example.task.service.ProductService;
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

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class DefaultProductDtoServiceTest {
    @InjectMocks
    private DefaultProductDtoService defaultProductDtoService;

    @Mock
    private ProductService productService;

    @Mock
    private ProductMapper productMapper;

    @Mock
    private LanguageService languageService;

    @Mock
    private CurrencyService currencyService;

    private ProductDto productDto;
    private LanguageDto languageDto;
    private CurrencyDto currencyDto;
    private Product product;
    private Language language;
    private Currency currency;
    private CreateProductDto createProductDto;
    private UpdateProductDto updateProductDto;

    private String string;
    private Date date;
    private BigDecimal decimal;

    @BeforeEach
    void setUp() {
        defaultProductDtoService = new DefaultProductDtoService(productService, productMapper, languageService, currencyService);

        string = "something";
        date = new Date();
        decimal = new BigDecimal(10);

        language = new Language();
        language.setId(1L);
        language.setLanguage(string);

        currency = new Currency();
        currency.setId(1L);
        currency.setCurrency(string);

        product = new Product();
        product.setId(1L);
        product.setName(string);
        product.setDescription(string);
        product.setPrice(decimal);
        product.setModificationDate(date);
        product.setCreationDate(date);
        product.setLanguage(language);
        product.setCurrency(currency);

        languageDto = new LanguageDto();
        languageDto.setId(1L);
        languageDto.setLanguage(string);

        currencyDto = new CurrencyDto();
        currencyDto.setId(1L);
        currencyDto.setCurrency(string);

        productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setName(string);
        productDto.setDescription(string);
        productDto.setModificationDate(date);
        productDto.setCreationDate(date);
        productDto.setPrice(decimal);
        productDto.setCurrencyDto(currencyDto);
        productDto.setLanguageDto(languageDto);

        createProductDto = new CreateProductDto();
        createProductDto.setId(1L);
        createProductDto.setName(string);
        createProductDto.setDescription(string);
        createProductDto.setPrice(decimal);
        createProductDto.setCreationDate(date);
        createProductDto.setModificationDate(date);
        createProductDto.setCurrencyId(1L);
        createProductDto.setLanguageId(1L);

        updateProductDto = new UpdateProductDto();
        updateProductDto.setName(string);
        updateProductDto.setDescription(string);
        updateProductDto.setPrice(decimal);
        updateProductDto.setCreationDate(date);
        updateProductDto.setModificationDate(date);
        updateProductDto.setCurrencyId(1L);
        updateProductDto.setLanguageId(1L);
    }

    @AfterEach
    void tearDown() {
        product = null;
        productDto = null;
        currencyDto = null;
        languageDto = null;
        createProductDto = null;
        updateProductDto = null;
        string = null;
        decimal = null;
        date = null;
    }

    @Test
    void getById_withValidId_shouldReturnProductDto() {
        when(productService.getById(1L)).thenReturn(product);
        when(productMapper.toProductDto(product)).thenReturn(productDto);

        ProductDto productDto = defaultProductDtoService.getById(1L);

        assertEquals(1L, productDto.getId());
        assertEquals(string, productDto.getName());
        assertEquals(string, productDto.getDescription());
        assertEquals(date, productDto.getCreationDate());
        assertEquals(date, productDto.getModificationDate());
        assertEquals(decimal, productDto.getPrice());
        assertEquals(languageDto, productDto.getLanguageDto());
        assertEquals(currencyDto, productDto.getCurrencyDto());

        verify(productService, times(1)).getById(1L);
    }

    @Test
    void getAll_withValidData_shouldReturnProductDtos() {
        when(productService.getAll()).thenReturn(Collections.singletonList(product));
        when(productMapper.toProductDto(product)).thenReturn(productDto);

        List<ProductDto> productDtos = defaultProductDtoService.getAll();

        assertThat(productDtos).hasSize(1);

        verify(productService, times(1)).getAll();
    }

    @Test
    void create_withValidData_shouldReturnProductDto() {
        when(languageService.getById(1L)).thenReturn(language);
        when(currencyService.getById(1L)).thenReturn(currency);
        when(productService.save(any())).thenReturn(product);
        when(productMapper.toProductDto(product)).thenReturn(productDto);

        ProductDto productDto = defaultProductDtoService.create(createProductDto);

        assertEquals(1L, productDto.getId());
        assertEquals(string, productDto.getName());
        assertEquals(string, productDto.getDescription());
        assertEquals(date, productDto.getCreationDate());
        assertEquals(date, productDto.getModificationDate());
        assertEquals(decimal, productDto.getPrice());
        assertEquals(1L, productDto.getLanguageDto().getId());
        assertEquals(1L, productDto.getCurrencyDto().getId());

        verify(productService, times(1)).save(any());
    }

    @Test
    void update_withValidIdAndData_shouldReturnProductDto() {
        when(productService.getById(1L)).thenReturn(product);
        when(languageService.getById(1L)).thenReturn(language);
        when(currencyService.getById(1L)).thenReturn(currency);
        when(productService.save(any())).thenReturn(product);
        when(productMapper.toProductDto(product)).thenReturn(productDto);

        ProductDto productDto = defaultProductDtoService.update(1L, updateProductDto);

        assertEquals(1L, productDto.getId());
        assertEquals(string, productDto.getName());
        assertEquals(string, productDto.getDescription());
        assertEquals(date, productDto.getCreationDate());
        assertEquals(date, productDto.getModificationDate());
        assertEquals(decimal, productDto.getPrice());
        assertEquals(1L, productDto.getLanguageDto().getId());
        assertEquals(1L, productDto.getCurrencyDto().getId());

        verify(productService, times(1)).save(any());
    }
}