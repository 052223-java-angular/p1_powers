package com.revature.hikingbuddy.utils.custom_exceptions;

public class TrailDoesNotExistException extends RuntimeException{

    public TrailDoesNotExistException(String message)
    {
        super(message);
    }
    
}
