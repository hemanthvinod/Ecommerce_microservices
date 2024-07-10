package com.microservices.Order.mapper;

import com.microservices.Order.domain.Order;
import com.microservices.Order.domain.OrderLine;
import com.microservices.Order.service.resource.OrderLineRequest;
import com.microservices.Order.service.resource.OrderLineResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {


    public OrderLine toOrderLine(OrderLineRequest orderLineRequest) {
        return OrderLine.builder()
                .Id(orderLineRequest.getId())
                .quantity(orderLineRequest.getQuantity())
                .order(Order.builder().Id(orderLineRequest.getOrderId()).build())
                .productId(orderLineRequest.getProductId())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponse(orderLine.getId(),orderLine.getQuantity());
    }
}
