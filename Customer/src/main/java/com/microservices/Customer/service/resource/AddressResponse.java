package com.microservices.Customer.service.resource;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressResponse {
    private String street;
    private String houseNumber;
    private String zipCode;
}
