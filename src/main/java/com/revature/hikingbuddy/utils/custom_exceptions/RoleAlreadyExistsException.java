
package com.revature.hikingbuddy.utils.custom_exceptions;

public class RoleAlreadyExistsException extends RuntimeException{
    public RoleAlreadyExistsException(String message)
    {
        super(message);
    }
    
}
