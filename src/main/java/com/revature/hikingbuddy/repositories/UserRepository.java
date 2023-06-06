package com.revature.hikingbuddy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.hikingbuddy.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

    public User findByUsername(String username);

    public List<User> findAllUsers();

    public boolean insertUser(User user);
    
    
}
