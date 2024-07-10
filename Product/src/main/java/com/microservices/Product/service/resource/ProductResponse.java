package com.microservices.Product.service.resource;


import com.microservices.Product.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Long Id;
    private String name;
    private String description;
    private Double availableQuantity;
    private BigDecimal price;
    private Long categoryId;
    private String categoryName;
    private String categoryDescription;
}
