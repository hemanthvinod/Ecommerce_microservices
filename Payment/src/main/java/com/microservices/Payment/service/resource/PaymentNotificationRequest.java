package com.microservices.Payment.service.resource;

import com.microservices.Payment.domain.PaymentMethod;

import java.math.BigDecimal;

public record PaymentNotificationRequest(
        Long orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstName,
        String customerLastName,
        String customerEmail
) {
}
