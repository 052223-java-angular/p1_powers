package com.revature.hikingbuddy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.hikingbuddy.dtos.requests.NewUserRequest;
import com.revature.hikingbuddy.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userservice;

    @Autowired
    private AuthController(UserService userservice)
    {
        this.userservice = userservice;
    }


    @PostMapping("/register")
    public ResponseEntity<?> createuser(@RequestBody NewUserRequest req)
    {
         






        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
   
    
}
