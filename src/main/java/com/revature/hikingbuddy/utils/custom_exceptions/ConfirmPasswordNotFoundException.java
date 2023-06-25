package com.revature.hikingbuddy.utils.custom_exceptions;

public class ConfirmPasswordNotFoundException extends RuntimeException{

    public ConfirmPasswordNotFoundException(String message)
    {
        super(message);
    }
    
}
