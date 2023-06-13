package com.revature.hikingbuddy.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hikingbuddy.dtos.requests.NewRatingRequest;
import com.revature.hikingbuddy.entities.TrailRating;
import com.revature.hikingbuddy.entities.Trail;
import com.revature.hikingbuddy.entities.User;
import com.revature.hikingbuddy.repositories.RatingRepository;

@Service
public class RatingService {
    private RatingRepository ratingrepo;
    private UserService userservice;

    @Autowired
    public RatingService(RatingRepository ratingrepo, UserService userservice)
    {
        this.ratingrepo = ratingrepo;
        this.userservice = userservice;
    }

    public TrailRating saveRating(NewRatingRequest rq)
    {
        TrailRating rating = new TrailRating();
        User user = new User();
        Trail trail = new Trail();
        rating.setId(UUID.randomUUID().toString());
        rating.setRating(rq.getRating());
        rating.setComment(rq.getComment());
        user.setId(rq.getUser_id());
        rating.setUser_id(user);
        trail.setName(rq.getTrail_name());
        rating.setTrail_name(trail);
        ratingrepo.save(rating);

        return rating;



    }
    

}
