package com.revature.hikingbuddy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hikingbuddy.entities.User;
import com.revature.hikingbuddy.repositories.UserRepository;

import lombok.AllArgsConstructor;



@Service
public class UserService {

    private final UserRepository userrepo;
    private UserService instance;


    @Autowired
    private UserService(UserRepository userrepo)
    {
        this.userrepo = userrepo;
    }


    public UserService getInstance()
    {
        if(instance == null)
        {
            instance = new UserService(userrepo);
        }

        return instance;
    }

    public List<User> callFindAllUsers()
    {
        return userrepo.findAllUsers();
    }

    




    


    
}
