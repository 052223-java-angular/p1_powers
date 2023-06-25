package com.revature.hikingbuddy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.hikingbuddy.dtos.responses.TopRatedTrailsResponse;
import com.revature.hikingbuddy.dtos.responses.TrailRatingsByNameResponse;
import com.revature.hikingbuddy.entities.TrailRating;

@Repository
public interface RatingRepository extends JpaRepository<TrailRating, String>{

    @Query(value="SELECT trail_rating.trail_name, avg(trail_rating.rating) AS avg_rating from trail_rating GROUP BY trail_name ORDER BY avg_rating DESC LIMIT 5", nativeQuery = true)
    public List<TopRatedTrailsResponse> findTopRatedTrails();

    @Query(value="SELECT * FROM trail_rating where trail_name = :name", nativeQuery = true)
    public List<TrailRating> findTrailRatingsByName(@Param("name") String name);

    
    
}
