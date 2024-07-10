package com.microservices.Customer.service.resource;


import com.microservices.Customer.domain.Customer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequest {
    @NotBlank(message = "first name cannot be blank")
    private String firstName;
    @NotBlank(message = "last name cannot be blank")
    private String lastName;
    @Email(message = "email cannot be blank")
    private String email;
    @Valid
    private AddressRequest address;

    public Customer toCustomer(){
        return Customer.builder().firstName(firstName)
                .lastName(lastName)
                .email(email)
                .address(address.toAddress())
                .build();
    }
}
