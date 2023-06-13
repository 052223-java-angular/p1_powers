package com.revature.hikingbuddy.utils.custom_exceptions;

public class UserTrailDoesNotExistException extends RuntimeException{
    public UserTrailDoesNotExistException(String message)
    {
        super(message);
    }
    
}
