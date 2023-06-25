package com.revature.hikingbuddy.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.hikingbuddy.dtos.requests.NewRoleRequest;
import com.revature.hikingbuddy.entities.Role;
import com.revature.hikingbuddy.services.RoleService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@CrossOrigin(origins="http://localhost:4200", exposedHeaders="Access-Control-Allow-Origin")
@RestController
@RequestMapping("/roles")
public class RoleController {
    /*
     * This class allows the user to create a role in the system whenever the /roles endpoint is created
     */
    private RoleService roleservice;

  

    @PostMapping("/create")
    public ResponseEntity<?> createRole(@RequestBody NewRoleRequest rq)
    {
        roleservice.saveRole(rq);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
