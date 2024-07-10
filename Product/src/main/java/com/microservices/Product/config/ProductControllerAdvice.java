package com.microservices.Product.config;

import com.microservices.Product.exception.ProductException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ProductControllerAdvice {
    @ExceptionHandler(ProductException.class)
    public String handleCustomerException(ProductException exception){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("type", exception.getType());
        errorMap.put("message", exception.getMessage());
        return errorMap.toString();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        Map<String, String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error-> errorMap.put(error.getField(),error.getDefaultMessage()));
        return errorMap.toString();
    }
}
