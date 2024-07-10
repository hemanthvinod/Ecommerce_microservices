package com.microservices.Customer.controller;


import com.microservices.Customer.service.CustomerService;
import com.microservices.Customer.service.resource.CustomerRequest;
import com.microservices.Customer.service.resource.CustomerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request){
        return new ResponseEntity<>(customerService.createCustomer(request), HttpStatus.CREATED);
    }


    @PutMapping("/{Id}")
    public ResponseEntity<?> updateCustomer(@PathVariable String Id, @RequestBody @Valid CustomerRequest request){
        customerService.updateCustomer(Long.valueOf(Id),request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers(){
        return new ResponseEntity<>(customerService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable("Id") String Id){
        return new ResponseEntity<>(customerService.getCustomer(Long.valueOf(Id)),HttpStatus.OK);
    }

    @DeleteMapping("{Id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("Id") String Id){
        customerService.deleteCustomer(Long.valueOf(Id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
