package com.revature.hikingbuddy.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hikingbuddy.dtos.requests.NewUserRequest;
import com.revature.hikingbuddy.repositories.UserRepository;




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

   public void saveUser(NewUserRequest user)
   {
        userrepo.save(user);
   }

   


    
}
