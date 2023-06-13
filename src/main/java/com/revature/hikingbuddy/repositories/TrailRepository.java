package com.revature.hikingbuddy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.hikingbuddy.entities.Trails;

@Repository
public interface TrailRepository extends JpaRepository<Trails, String>{
    
}
