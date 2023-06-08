package com.revature.hikingbuddy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.hikingbuddy.dtos.requests.GetUserRequest;
import com.revature.hikingbuddy.dtos.requests.NewUserRequest;
import com.revature.hikingbuddy.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private final UserService userservice;


    @PostMapping("/register")
    public ResponseEntity<?> createuser(@RequestBody NewUserRequest req)
    {
        System.out.println("In responseHandler");
        userservice.registerUser(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody GetUserRequest rq)
    {
        
        return ResponseEntity.status(HttpStatus.OK).build();
    }
   
    
}
