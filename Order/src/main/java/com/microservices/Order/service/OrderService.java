package com.microservices.Order.service;

import java.util.List;
import java.util.stream.Collectors;

import com.microservices.Order.customer.CustomerClient;
import com.microservices.Order.exception.OrderException;
import com.microservices.Order.kafka.OrderProducer;
import com.microservices.Order.mapper.OrderMapper;
import com.microservices.Order.payment.PaymentClient;
import com.microservices.Order.product.ProductClient;
import com.microservices.Order.repository.OrderRepository;
import com.microservices.Order.service.resource.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final PaymentClient paymentClient;
    private final OrderMapper orderMapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;

    public Long createOrder(OrderRequest orderRequest) {
        //checking if customer exists

        var customer = customerClient.findCustomerById(orderRequest.getCustomerId())
                .orElseThrow(()-> new OrderException("ORDER_PROCESSING_EXCEPTION", "customer cannot be found"));

        //ordering the products

        var purchasedProducts = productClient.purchaseProducts(orderRequest.getProducts());

        //saving the order to the database

        var order = orderRepository.save(orderMapper.toOrder(orderRequest));

        for(PurchaseRequest purchaseRequest: orderRequest.getProducts()){
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.getProductId(),
                            purchaseRequest.getQuantity()
                    )
            );
        }

        // payment initiation
        System.out.println(orderRequest.getAmount()+" "+orderRequest.getReference()+" "+orderRequest.getCustomerId());
        var paymentRequest = new PaymentRequest(
                orderRequest.getAmount(),
                orderRequest.getPaymentMethod(),
                order.getId(),
                orderRequest.getReference(),
                customer);
        paymentClient.requestOrderPayment(paymentRequest);

        // notification
        // sending the message to Kafka
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        orderRequest.getReference(),
                        orderRequest.getAmount(),
                        orderRequest.getPaymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

    return order.getId();
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toOrderResponse)
                .collect(Collectors.toList());
    }

    public OrderResponse getOrder(Long Id) {
        return orderRepository.findById(Id).map(orderMapper::toOrderResponse)
                .orElseThrow(()-> new OrderException("ORDER_NOT_FOUND_EXCEPTION","the order with id "+Id+" could not be found"));
    }
}
