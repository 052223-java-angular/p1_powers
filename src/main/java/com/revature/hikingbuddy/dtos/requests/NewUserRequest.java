package com.revature.hikingbuddy.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class NewUserRequest {

    private String username;
    private String password;
    private String confirmPassword;

    
}
