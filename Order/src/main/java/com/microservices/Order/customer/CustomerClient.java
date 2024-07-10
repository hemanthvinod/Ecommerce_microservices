package com.microservices.Order.customer;


import com.microservices.Order.service.resource.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name="customer-service",
        url = "${application.config.customer-url}"
)
public interface CustomerClient {
    @GetMapping("/{Id}")
    Optional<CustomerResponse> findCustomerById(@PathVariable("Id") Long customerId);
}
