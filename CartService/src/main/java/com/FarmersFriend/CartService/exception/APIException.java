package com.FarmersFriend.CartService.exception;

public class APIException extends RuntimeException{

    public APIException(String message) {
       super(message);
    }
    public APIException(){


    }
}
