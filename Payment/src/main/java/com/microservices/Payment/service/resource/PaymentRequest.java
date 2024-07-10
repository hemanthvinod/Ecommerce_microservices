package com.microservices.Payment.service.resource;
import com.microservices.Payment.domain.PaymentMethod;
import java.math.BigDecimal;

public record PaymentRequest(
        Long Id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Long orderId,
        Long orderReference,
        Customer customer
) {
}
