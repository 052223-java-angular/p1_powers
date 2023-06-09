package com.revature.hikingbuddy.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.revature.hikingbuddy.dtos.requests.NewRatingRequest;
import com.revature.hikingbuddy.entities.TrailRating;
import com.revature.hikingbuddy.entities.Trails;
import com.revature.hikingbuddy.entities.User;
import com.revature.hikingbuddy.repositories.RatingRepository;

@Service
public class RatingService {
    private RatingRepository ratingrepo;
    private UserService userservice;

    public TrailRating saveRating(NewRatingRequest rq)
    {
        TrailRating rating = new TrailRating();
        rating.setId(UUID.randomUUID().toString());
        rating.setRating(rq.getRating());
        rating.setComment(rq.getComment());
        rating.setTrail_name(rq.getTrail_name());
        User user = userservice.getUserById(rq.getUser_id());
        rating.setUser_id(user);
        ratingrepo.save(rating);
        return rating;



    }
    

}
