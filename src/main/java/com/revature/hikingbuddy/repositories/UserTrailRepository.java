package com.revature.hikingbuddy.repositories;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.hikingbuddy.entities.Trail;
import com.revature.hikingbuddy.entities.User;
import com.revature.hikingbuddy.entities.UserTrail;

@Repository
public interface UserTrailRepository extends JpaRepository<UserTrail, String>
{

    @Query(value = "SELECT * FROM user_trail WHERE user_id =:user_id AND trail_name =:trail_name", nativeQuery = true)
    public Optional<UserTrail> findUserTrailByUser_id(@Param("user_id") String user_id, @Param("trail_name") String trail_name);

    @Query(value = "SELECT * FROM trails LEFT OUTER JOIN user_trail ON trails.name = user_trail.trail_name WHERE user_trail.trail_name IS NULL and user_trail.user_id =:id", nativeQuery = true)
    public List<Trail> findAllTrailsNotHiked(@Param("id") String user_id);
   
    
}
