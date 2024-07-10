package com.microservices.Order.service.resource;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PurchaseResponse {
    private Long productId;
    private String name;
    private String description;
    private BigDecimal price;
    private Double quantity;
}
