package com.microservices.Order.service;

import com.microservices.Order.mapper.OrderLineMapper;
import com.microservices.Order.repository.OrderLineRepository;
import com.microservices.Order.service.resource.OrderLineRequest;
import com.microservices.Order.service.resource.OrderLineResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;
    private final OrderLineMapper orderLineMapper;

    public Long saveOrderLine(OrderLineRequest orderLineRequest) {
        var order = orderLineMapper.toOrderLine(orderLineRequest);
        return orderLineRepository.save(order).getId();
    }

    public List<OrderLineResponse> findAlLOrdersById(Long Id) {
        return orderLineRepository.findAllByOrderId(Id).stream()
                .map(orderLineMapper::toOrderLineResponse)
                .collect(Collectors.toList());
    }
}
