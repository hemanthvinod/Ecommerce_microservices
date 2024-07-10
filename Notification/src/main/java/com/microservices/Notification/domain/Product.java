package com.microservices.Notification.domain;

import java.math.BigDecimal;

public record Product(
        Long productId,
        String name,
        String description,
        BigDecimal price,
        Double quantity
) {
}
