package com.example.task.dto;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class UpdateProductDto {
    private String name;
    private Date creationDate;
    private Date modificationDate;

    @NotNull
    private String description;

    @NotNull
    @DecimalMin(value = "0.0", message = "Price must be positive!")
    private BigDecimal price;

    @NotNull
    private Long languageId;

    @NotNull
    private Long currencyId;
}