package com.microservices.Order.mapper;


import com.microservices.Order.domain.Order;
import com.microservices.Order.service.resource.OrderRequest;
import com.microservices.Order.service.resource.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public Order toOrder(OrderRequest orderRequest){
            return Order.builder()
                    .Id(orderRequest.getId())
                    .customerId(orderRequest.getCustomerId())
                    .reference(orderRequest.getReference())
                    .totalAmount(orderRequest.getAmount())
                    .totalAmount(orderRequest.getAmount())
                    .paymentMethod(orderRequest.getPaymentMethod())
                    .build();
    }

    public OrderResponse toOrderResponse(Order order) {
        return OrderResponse.builder()
                .Id(order.getId())
                .amount(order.getTotalAmount())
                .reference(order.getReference())
                .paymentMethod(order.getPaymentMethod())
                .customerId(order.getCustomerId())
                .build();
    }
}
