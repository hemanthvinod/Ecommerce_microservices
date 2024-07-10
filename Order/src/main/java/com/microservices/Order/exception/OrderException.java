package com.microservices.Order.exception;

public class OrderException extends RuntimeException{
    private String type;
    private String message;

    public OrderException(String type, String message){
        this.type = type;
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
    public String getType(){
        return this.type;
    }
}
