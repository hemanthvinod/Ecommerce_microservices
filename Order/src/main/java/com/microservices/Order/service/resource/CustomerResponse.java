package com.microservices.Order.service.resource;


import lombok.Getter;

@Getter
public class CustomerResponse {
    private Long Id;
    private String firstName;
    private String lastName;
    private String email;
}
