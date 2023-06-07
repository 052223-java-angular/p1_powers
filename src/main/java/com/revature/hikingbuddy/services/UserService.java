package com.revature.hikingbuddy.services;



import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hikingbuddy.dtos.requests.NewRoleRequest;
import com.revature.hikingbuddy.dtos.requests.NewUserRequest;
import com.revature.hikingbuddy.entities.Role;
import com.revature.hikingbuddy.entities.User;
import com.revature.hikingbuddy.repositories.UserRepository;
import com.revature.hikingbuddy.utils.custom_exceptions.RoleNotFoundException;




@Service
public class UserService {
    private final UserRepository userrepo;
    private RoleService roleservice;
    private UserService instance;

   @Autowired
   private UserService(UserRepository userrepo, RoleService roleservice)
   {
     this.userrepo = userrepo;
     this.roleservice = roleservice;
   }
   
   public void registerUser(NewUserRequest rq)
   {
       System.out.println("in registerUser");
       Role role = getUserRole("USER");
       User user = new User();
       user.setId(UUID.randomUUID().toString());
       user.setUsername(rq.getUsername());
       user.setPassword(rq.getPassword());
       user.setRole_id(role);
       saveUser(user);
   }

   public Role getUserRole(String name)
   {
        Optional<Role> roleOpt = roleservice.getRoleByName(name);

        if(roleOpt.isPresent())
        {
            Role role = roleOpt.get();
            return role;
        }
        else
        {
          throw new RoleNotFoundException("Role Not foudn. Exception thrown at UserService.getUserRole()");
        }

        
   }
   public UserService getInstance()
   {
        if(instance == null)
        {
            instance = new UserService(userrepo, roleservice);
        }

        return instance;
   }

   private void saveUser(User user)
   {
        userrepo.save(user);
   }


   


    
}
