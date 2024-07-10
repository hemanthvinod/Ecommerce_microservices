package com.microservices.Order.config;

import com.microservices.Order.exception.OrderException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class OrderControllerAdvice {
    @ExceptionHandler(OrderException.class)
    public String handleCustomerException(OrderException exception){
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
