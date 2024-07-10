package com.microservices.Customer.service;

import com.microservices.Customer.domain.Address;
import com.microservices.Customer.domain.Customer;
import com.microservices.Customer.exception.CustomerException;
import com.microservices.Customer.mapper.CustomerMapper;
import com.microservices.Customer.repository.CustomerRepository;
import com.microservices.Customer.service.resource.AddressRequest;
import com.microservices.Customer.service.resource.CustomerRequest;
import com.microservices.Customer.service.resource.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public String createCustomer(CustomerRequest customerRequest){
       Customer customer =  customerRepository.save(customerRequest.toCustomer());
       return String.valueOf(customer.getId());
    }

    public void updateCustomer(Long Id,CustomerRequest request) {
        Optional<Customer> customerOptional = customerRepository.findById(Id);
        if(customerOptional.isPresent()){
            Customer customer = customerOptional.get();
            customer.setFirstName(request.getFirstName());
            customer.setLastName(request.getLastName());
            customer.setEmail(request.getEmail());

            AddressRequest updatedAddress = request.getAddress();
                    if(Objects.nonNull(updatedAddress)){
                        Address address = customer.getAddress();
                        address.setHouseNumber(updatedAddress.getHouseNumber());
                        address.setStreet(updatedAddress.getStreet());
                        address.setZipCode(updatedAddress.getZipCode());
                    }
            customerRepository.save(customer);
        }else{
           throw new CustomerException("CUSTOMER_NOT_FOUND_EXCEPTION","the customer with the specified Id was not found");
        }
    }

    public List<CustomerResponse> findAll() {
        return customerRepository.findAll().stream()
                .map(CustomerMapper::toCustomerResponse)
                .collect(Collectors.toList());
    }

    public CustomerResponse getCustomer(Long Id) {
        Optional<Customer> optionalCustomer= customerRepository.findById(Id);
        if(optionalCustomer.isPresent()){
            return CustomerMapper.toCustomerResponse(optionalCustomer.get());
        }
        throw new CustomerException("CUSTOMER_NOT_FOUNT_EXCEPTION","the customer with Id is not found");
    }

    public void deleteCustomer(Long Id) {
        Optional<Customer> optionalCustomer= customerRepository.findById(Id);
        if(optionalCustomer.isPresent()){
            customerRepository.delete(optionalCustomer.get());
        }else{
            throw new CustomerException("USER_NOT_FOUND_EXCEPTION","the user with Id was not found");
        }
    }
}
