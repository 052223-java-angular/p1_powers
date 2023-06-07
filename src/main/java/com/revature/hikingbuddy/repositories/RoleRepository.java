package com.revature.hikingbuddy.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.hikingbuddy.entities.Role;

public interface RoleRepository extends JpaRepository<Role, String>{

    public Optional<Role> findByName(String name);
   

    
}
