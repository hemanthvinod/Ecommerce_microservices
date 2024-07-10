package com.microservices.Product.service.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPurchaseResponse {
    private Long productId;
    private String name;
    private String description;
    private BigDecimal price;
    private Double quantity;
}
