package com.microservices.Order.controller;

import com.microservices.Order.service.OrderService;
import com.microservices.Order.service.resource.OrderRequest;
import com.microservices.Order.service.resource.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Long> createOrder(@RequestBody OrderRequest orderRequest){
        return new ResponseEntity<>(orderService.createOrder(orderRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders(){
        return new ResponseEntity<>(orderService.getAllOrders(),HttpStatus.OK);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable("Id") String Id){
        return new ResponseEntity<>(orderService.getOrder(Long.valueOf(Id)), HttpStatus.OK);
    }

    
}
