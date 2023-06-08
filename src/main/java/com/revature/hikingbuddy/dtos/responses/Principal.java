package com.revature.hikingbuddy.dtos.responses;

import com.revature.hikingbuddy.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Principal {
    private String id;
    private String username;
    private String token;
    private String role;

    public Principal(User user)
    {
        this.id = user.getId();
        this.username = user.getUsername();
        this.role = user.getRole_id().getName();
    }
    
}
