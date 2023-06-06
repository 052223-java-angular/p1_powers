package com.revature.hikingbuddy.dtos.requests;

import java.util.UUID;

public class NewUser {
    private String id;
    private String username;
    private String password;

    private NewUser(String username, String password)
    {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
    }

    public NewUser createNewUser(String username, String password)
    {
        return new NewUser(username, password);
    }
    
}
