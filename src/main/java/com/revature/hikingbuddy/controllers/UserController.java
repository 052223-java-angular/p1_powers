package com.revature.hikingbuddy.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.hikingbuddy.entities.User;



@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping("/login")
    public User getUserByUsername(@PathVariable String username)
    {
       throw new RuntimeException();
    }

    @PostMapping("/register")
    public User createUser()
    {
        throw new RuntimeException();
    }




    
    
}
