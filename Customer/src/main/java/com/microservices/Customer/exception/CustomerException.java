package com.microservices.Customer.exception;

public class CustomerException extends RuntimeException{

    private String type;
    private String message;

    public CustomerException(String type, String message){
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
