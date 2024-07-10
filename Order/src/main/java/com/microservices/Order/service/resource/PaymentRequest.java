package com.microservices.Order.service.resource;

import com.microservices.Order.domain.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Long orderId,
        Long orderReference,
        CustomerResponse customer
) {
}
