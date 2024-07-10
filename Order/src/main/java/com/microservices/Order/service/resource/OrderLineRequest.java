package com.microservices.Order.service.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineRequest {
    private Long Id;
    private Long orderId;
    private Long productId;
    private Double quantity;
}
