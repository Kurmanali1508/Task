package com.example.task.controller;

import com.example.task.dto.ProductDto;
import com.example.task.dtoService.ProductClientResourceDtoService;
import com.example.task.exceptions.ProductNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productClientResource")
public class ProductClientResourceController {
    private final ProductClientResourceDtoService productClientResourceDtoService;

    @Autowired
    public ProductClientResourceController(ProductClientResourceDtoService productClientResourceDtoService) {
        this.productClientResourceDtoService = productClientResourceDtoService;
    }

    @GetMapping
    public List<ProductDto> getAllProductsByNameOrDescription(@RequestParam("name") String name, @RequestParam("description") String description) {
        return productClientResourceDtoService.getAllProductsByNameOrDescriptions(name, description);
    }

    @GetMapping("/getByLanguageAndCurrency")
    public List<ProductDto> getAllProductsByLanguageAndCurrency(@RequestParam("languageId") Long languageId, @RequestParam("currencyId") Long currencyId) {
        return productClientResourceDtoService.getAllProductsByLanguageAndCurrency(languageId, currencyId);
    }

    @GetMapping("/getByLanguageOrCurrency")
    public List<ProductDto> getAllProductsByLanguageOrCurrency(@RequestParam Long languageId, @RequestParam Long currencyId) {
        return productClientResourceDtoService.getAllProductsByLanguageOrCurrency(languageId, currencyId);
    }

    @GetMapping("/{getById}")
    public ResponseEntity<ProductDto> getById(@PathVariable("getById") Long id, @RequestParam Long languageId, @RequestParam Long currencyId) throws ProductNotFound {
        return new ResponseEntity<ProductDto>((productClientResourceDtoService.getById(id, languageId, currencyId)), HttpStatus.OK);
    }
}