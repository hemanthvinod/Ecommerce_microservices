package com.microservices.Customer.service.resource;

import com.microservices.Customer.domain.Address;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponse {

    private Long Id;
    private String firstName;
    private String lastName;
    private String email;
    private AddressResponse address;

}
