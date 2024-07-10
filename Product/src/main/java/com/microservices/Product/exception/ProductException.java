package com.microservices.Product.exception;

public class ProductException extends RuntimeException{
    private String type;
    private String message;

    public ProductException(String type, String message){
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
