package com.microservices.Order.service.resource;

// learning to use a Record
public record OrderLineResponse (
    Long Id,
    Double quantity
){}
