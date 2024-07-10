package com.microservices.Payment.service.resource;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Customer(
        Long Id,
        @NotNull(message = "first name cannot be empty")
        String firstName,
        @NotNull(message = "last name cannot be empty")
        String lastName,
        @NotNull(message = "email cannot be empty")
        @Email(message = "email should be valid")
        String email
) {
}
