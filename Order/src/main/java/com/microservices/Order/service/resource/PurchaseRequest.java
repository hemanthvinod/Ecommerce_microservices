package com.microservices.Order.service.resource;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;


@Getter
public class PurchaseRequest {
    @NotNull(message = "product is mandatory")
    private Long productId;
    @Positive(message = "quantity is mandatory")
    private Double quantity;
}
