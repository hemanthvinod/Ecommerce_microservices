package com.microservices.Customer.mapper;

import com.microservices.Customer.domain.Address;
import com.microservices.Customer.domain.Customer;
import com.microservices.Customer.service.resource.AddressResponse;
import com.microservices.Customer.service.resource.CustomerResponse;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public static CustomerResponse toCustomerResponse(Customer customer) {
        if (customer == null) {
            return null;
        }
        CustomerResponse response = new CustomerResponse();
        response.setId(customer.getId());
        response.setFirstName(customer.getFirstName());
        response.setLastName(customer.getLastName());
        response.setEmail(customer.getEmail());

        Address address = customer.getAddress();
        if (address != null) {
            AddressResponse addressResponse = new AddressResponse();
            addressResponse.setStreet(address.getStreet());
            addressResponse.setHouseNumber(address.getHouseNumber());
            addressResponse.setZipCode(address.getZipCode());
            response.setAddress(addressResponse);
        }
        return response;
    }
}
