package com.revature.hikingbuddy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.hikingbuddy.entities.TrailRating;

@Repository
public interface RatingRepository extends JpaRepository<TrailRating, String>{
    
}
