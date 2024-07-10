package com.microservices.Order.service.resource;

import com.microservices.Order.domain.PaymentMethod;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Builder
@Getter
public class OrderResponse {

    private Long Id;
    private Long reference;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private Long customerId;
}
