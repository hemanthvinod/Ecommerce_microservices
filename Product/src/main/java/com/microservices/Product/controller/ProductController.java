package com.microservices.Product.controller;


import com.microservices.Product.service.ProductService;
import com.microservices.Product.service.resource.ProductPurchaseRequest;
import com.microservices.Product.service.resource.ProductPurchaseResponse;
import com.microservices.Product.service.resource.ProductRequest;
import com.microservices.Product.service.resource.ProductResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Long> createProduct(@RequestBody @Valid ProductRequest productRequest){
        return new ResponseEntity<>(productService.createProduct(productRequest), HttpStatus.CREATED);
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(
            @RequestBody List<ProductPurchaseRequest> productPurchaseRequest){
        return new ResponseEntity<>(productService.purchaseProducts(productPurchaseRequest),HttpStatus.OK);
    }

    @GetMapping("/productId")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable String Id){
        return new ResponseEntity<>(productService.getProduct(Long.valueOf(Id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }


}
