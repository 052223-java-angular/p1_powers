package com.revature.hikingbuddy.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.hikingbuddy.entities.Trail;
import com.revature.hikingbuddy.entities.UserTrail;

@Repository
public interface UserTrailRepository extends JpaRepository<UserTrail, String>{

    public Optional<UserTrail> findUserTrailByTrailName(Trail trail_name);
    
}
