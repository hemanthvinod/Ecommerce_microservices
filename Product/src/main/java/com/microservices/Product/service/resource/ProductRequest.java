package com.microservices.Product.service.resource;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @NotBlank(message = "name cannot be blank")
    private String name;
    @NotBlank(message = "desc cannot be blank")
    private String description;
    @NotBlank(message = "quantity should be greater than 0")
    private Double availableQuantity;
    @NotBlank(message = "price should be greater than 0.00")
    private BigDecimal price;
    @NotBlank(message = "category cannot be empty")
    private Long categoryId;

}
