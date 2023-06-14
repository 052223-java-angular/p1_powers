package com.revature.hikingbuddy.repositories;



import java.util.Optional;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.revature.hikingbuddy.entities.Trail;



import com.revature.hikingbuddy.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

    public Optional<User> findByUsername(String username);
   
   
    
}
