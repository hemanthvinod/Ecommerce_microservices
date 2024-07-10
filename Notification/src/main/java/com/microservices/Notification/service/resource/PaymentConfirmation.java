package com.microservices.Notification.service.resource;

import com.microservices.Notification.domain.PaymentMethod;

import java.math.BigDecimal;

public record PaymentConfirmation(
        Long orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstName,
        String customerLastName,
        String customerEmail
) {
}
