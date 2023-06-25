package com.revature.hikingbuddy.services;



import java.util.Optional;
import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hikingbuddy.dtos.requests.NewLoginRequest;
import com.revature.hikingbuddy.dtos.requests.NewUserRequest;
import com.revature.hikingbuddy.dtos.responses.Principal;
import com.revature.hikingbuddy.entities.Role;
import com.revature.hikingbuddy.entities.User;
import com.revature.hikingbuddy.repositories.UserRepository;
import com.revature.hikingbuddy.utils.custom_exceptions.RoleNotFoundException;
import com.revature.hikingbuddy.utils.custom_exceptions.UserAlreadyExistsException;
import com.revature.hikingbuddy.utils.custom_exceptions.UserNotFoundException;




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
   
   public User registerUser(NewUserRequest rq)
   {

       System.out.println("in registerUser");
       Role role = getUserRole("USER");
       User user = new User();
       String hashed = BCrypt.hashpw(rq.getPassword(), BCrypt.gensalt());
       user.setId(UUID.randomUUID().toString());
       user.setUsername(rq.getUsername());
       user.setPassword(hashed);
       user.setRole_id(role);
       saveUser(user);
       return user;
     
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
          throw new RoleNotFoundException("Role Not found. Exception thrown at UserService.getUserRole()");
        }

        
   }
   public Principal login(NewLoginRequest rq)
   {
     
      Optional<User> userOpt = userrepo.findByUsername(rq.getUsername());

      if(userOpt.isPresent())
      {
         System.out.println("UserOpt.isPresent()");
         User user = userOpt.get();
         System.out.println("Password in user object: " + user.getPassword());
         System.out.println("rq.getPassword()" + rq.getPassword());
         if(BCrypt.checkpw(rq.getPassword(), user.getPassword()))
         {
            System.out.println("In the inner for loop");
            return new Principal(user);
         }
       
      }

      throw new UserNotFoundException("Your username and/or password is not correct");
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


   public User getUserById(String id)
   {
      Optional<User> userOpt = userrepo.findById(id);

      if(userOpt.isPresent())
      {
         User user = userOpt.get();
         return user;
      }

      throw new UserNotFoundException("User Not Found. Exception thrown at UserService.getUserById()");
   }


   public boolean isUniqueUsername(String username)
   {
      Optional<User> userOpt = userrepo.findByUsername(username);

      if(userOpt.isPresent())
      {
         return false;
      }

      return true;
   }


   


    
}
