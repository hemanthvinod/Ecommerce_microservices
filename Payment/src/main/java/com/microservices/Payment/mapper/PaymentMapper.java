package com.microservices.Payment.mapper;

import com.microservices.Payment.domain.Payment;
import com.microservices.Payment.service.resource.PaymentRequest;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {

    public Payment toPayment(PaymentRequest paymentRequest){
        return Payment.builder()
                .Id(paymentRequest.Id())
                .orderId(paymentRequest.orderId())
                .paymentMethod(paymentRequest.paymentMethod())
                .amount(paymentRequest.amount())
                .build();

    }
}
