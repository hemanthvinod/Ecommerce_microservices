package com.microservices.Customer.service.resource;

import com.microservices.Customer.domain.Address;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressRequest {

    @NotBlank(message = "street cannot be blank")
    private String street;
    @NotBlank(message = "house number cannot be blank")
    private String houseNumber;
    @NotBlank(message = "zipcode cannot be blank")
    private String zipCode;

    public Address toAddress(){
        return Address.builder()
                .street(street)
                .houseNumber(houseNumber)
                .zipCode(zipCode)
                .build();
    }
}
