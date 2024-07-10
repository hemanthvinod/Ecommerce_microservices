package com.microservices.Product.service.resource;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPurchaseRequest {
    @NotNull(message = "product is mandatory")
    private Long productId;
    @NotNull(message = "quantity is mandatory")
    private Double quantity;
}
