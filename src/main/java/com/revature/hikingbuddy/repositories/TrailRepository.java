package com.revature.hikingbuddy.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.hikingbuddy.entities.Trail;
import com.revature.hikingbuddy.entities.UserTrail;

@Repository
public interface TrailRepository extends JpaRepository<Trail, String>{
    
    public Optional<Trail> findTrailByName(String name);

    
    public List<Trail> findAll();

 

}
