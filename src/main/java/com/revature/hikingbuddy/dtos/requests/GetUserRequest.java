package com.revature.hikingbuddy.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GetUserRequest {
    private String username;
    private String password;
    
}
