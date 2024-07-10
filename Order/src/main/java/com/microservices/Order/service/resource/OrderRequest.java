package com.microservices.Order.service.resource;

import com.microservices.Order.domain.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class OrderRequest {
    private Long Id;
    private Long reference;
    @Positive(message = "Order amount should be greater than 0.00")
    private BigDecimal amount;
    @NotNull(message = "payment method should be selected")
    private PaymentMethod paymentMethod;
    @NotNull(message = "customer should be present")
    @NotEmpty(message = "customer should be present")
    @NotBlank(message = "customer should be present")
    private Long customerId;
    @NotEmpty(message = "should at least add one product")
    List<PurchaseRequest> products;
}
