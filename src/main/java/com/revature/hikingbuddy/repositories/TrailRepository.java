package com.revature.hikingbuddy.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.hikingbuddy.entities.Trail;

@Repository
public interface TrailRepository extends JpaRepository<Trail, String>{
    
    public Optional<Trail> findTrailByName(String name);
}
