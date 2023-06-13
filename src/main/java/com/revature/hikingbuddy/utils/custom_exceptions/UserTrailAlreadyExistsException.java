package com.revature.hikingbuddy.utils.custom_exceptions;

public class UserTrailAlreadyExistsException extends RuntimeException{
    public UserTrailAlreadyExistsException(String message)
    {
        super(message);
    }
}
