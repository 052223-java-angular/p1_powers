package com.revature.hikingbuddy;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.revature.hikingbuddy.controllers.AuthController;
import com.revature.hikingbuddy.dtos.requests.NewUserRequest;
import com.revature.hikingbuddy.entities.Role;
import com.revature.hikingbuddy.repositories.RoleRepository;
import com.revature.hikingbuddy.services.RoleService;
import com.revature.hikingbuddy.services.TokenService;
import com.revature.hikingbuddy.services.UserService;

public class HikingBuddyRegisterTest {

    @Mock 
    private UserService userService;

    @Mock
    private RoleService roleservice;

    @Mock
    private AuthController authcontroller;


    @Mock 
    private RoleRepository rolerepo;

   

    private NewUserRequest newuserrequest;

   


    @Before
    public void setUp()
    {
       
        
      

    }

    @Test
    public void registerTest()
    {
       ResponseEntity<?> rs = authcontroller.createuser(newuserrequest);

       Assert.assertEquals(rs.getStatusCode(), HttpStatus.CREATED);

       
    }

    
    
}
