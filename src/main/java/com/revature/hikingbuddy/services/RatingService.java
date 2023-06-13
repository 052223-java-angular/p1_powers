package com.revature.hikingbuddy.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hikingbuddy.dtos.requests.NewRatingRequest;
import com.revature.hikingbuddy.entities.TrailRating;
import com.revature.hikingbuddy.entities.Trail;
import com.revature.hikingbuddy.entities.User;
import com.revature.hikingbuddy.entities.UserTrail;
import com.revature.hikingbuddy.repositories.RatingRepository;
import com.revature.hikingbuddy.utils.custom_exceptions.UserTrailDoesNotExistException;

@Service
public class RatingService {
    private RatingRepository ratingrepo;
    private UserService userservice;
    private UserTrailService usertrailservice;

    @Autowired
    public RatingService(RatingRepository ratingrepo, UserService userservice, UserTrailService usertrailservice)
    {
        this.ratingrepo = ratingrepo;
        this.userservice = userservice;
        this.usertrailservice = usertrailservice;
    }

    public TrailRating saveRating(NewRatingRequest rq)
    {
       Trail trail = new Trail();
       trail.setName(rq.getTrail_name());
       Optional<UserTrail> userTrail = usertrailservice.findTrailByTrail_name(trail);

       if(userTrail.isEmpty())
       {
         throw new UserTrailDoesNotExistException("You have not hiked the trail you are trying to rate. Exception thrown at RatingService.saveRating");
       }

        

        TrailRating rating = new TrailRating();
        User user = new User();
        rating.setId(UUID.randomUUID().toString());
        rating.setRating(rq.getRating());
        rating.setComment(rq.getComment());
        user.setId(rq.getUser_id());
        rating.setUser_id(user);
        rating.setTrail_name(trail);
        ratingrepo.save(rating);
        return rating;



    }
    

}
