package com.revature.hikingbuddy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.hikingbuddy.entities.Trails;

@Repository
public interface TrailRepo extends JpaRepository<Trails, String>{

    public void addTrail();

    public Trails getTrailByName(String name);

    public void deleteTrail(String name);
    
    
}
