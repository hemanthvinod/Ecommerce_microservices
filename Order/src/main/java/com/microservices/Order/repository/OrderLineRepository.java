package com.microservices.Order.repository;

import com.microservices.Order.domain.OrderLine;
import com.microservices.Order.service.resource.OrderLineResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    List<OrderLine> findAllByOrderId(Long id);
}
