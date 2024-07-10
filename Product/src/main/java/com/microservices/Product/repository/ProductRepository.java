package com.microservices.Product.repository;

import com.microservices.Product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByIdInOrderById(List<Long> productIds);
}
