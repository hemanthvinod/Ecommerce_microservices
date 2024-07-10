package com.microservices.Notification.domain;

public record Customer(
        Long Id,
        String firstName,
        String lastName,
        String email
) {
}
