package com.microservices.Notification.service.resource;

import com.microservices.Notification.domain.Customer;
import com.microservices.Notification.domain.PaymentMethod;
import com.microservices.Notification.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
         Long orderReference,
         BigDecimal totalAmount,
         PaymentMethod paymentMethod,
         Customer customer,
         List<Product>products
) {
}
