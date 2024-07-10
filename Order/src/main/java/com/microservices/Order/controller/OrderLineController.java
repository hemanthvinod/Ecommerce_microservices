package com.microservices.Order.controller;

import com.microservices.Order.service.OrderLineService;
import com.microservices.Order.service.resource.OrderLineResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-lines")
@RequiredArgsConstructor
public class OrderLineController {

    private final OrderLineService orderLineService;

    @GetMapping("/order/{Id}")
    public ResponseEntity<List<OrderLineResponse>> findByOderId(@PathVariable("Id") Long Id){
        return new ResponseEntity<>(orderLineService.findAlLOrdersById(Id), HttpStatus.OK);
    }
}
