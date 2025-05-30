package com.FarmersFriend.ProductService.exception;

public class APIException extends RuntimeException{

    public APIException(String message) {
       super(message);
    }
    public APIException(){


    }
}
