package com.revature.hikingbuddy.repositories;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.hikingbuddy.entities.Trail;
import com.revature.hikingbuddy.entities.UserTrail;

@Repository
public interface UserTrailRepository extends JpaRepository<UserTrail, String>{

    public Optional<UserTrail> findUserTrailByTrailName(Trail trail_name);

    @Query(value = "SELECT * FROM trails LEFT OUTER JOIN user_trail ON trails.name = user_trail.trail_name WHERE user_trail.id IS NULL AND user_trail.user_id =:id", nativeQuery = true)
    public List<Trail> findAllTrailsNotHiked(@Param("id") String user_id);
   
    
}
