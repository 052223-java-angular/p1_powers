package com.revature.hikingbuddy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hikingbuddy.dtos.requests.NewRatingRequest;
import com.revature.hikingbuddy.dtos.responses.TopRatedTrailsResponse;
import com.revature.hikingbuddy.dtos.responses.TrailRatingsByNameResponse;
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
        System.out.println("User ID in saveRating: " + rq.getUser_id());
        System.out.println("Trail name in saveRating: " + rq.getTrailName());
       Optional<UserTrail> userTrail = usertrailservice.findTrailByUser_id(rq.getUser_id(), rq.getTrailName());

       if(userTrail.isEmpty())
       {
         throw new UserTrailDoesNotExistException("You have not hiked the trail you are trying to rate. Exception thrown at RatingService.saveRating");
       }
     
        System.out.println("Trail exists");
        TrailRating rating = new TrailRating();
        rating.setId(UUID.randomUUID().toString());
        rating.setRating(rq.getRating());
        rating.setComment(rq.getComment());
        User user = new User();
        user.setId(rq.getUser_id());
        rating.setUser_id(user);
        Trail trail = new Trail();
        trail.setName(rq.getTrailName());
        rating.setTrail_name(trail);
        ratingrepo.save(rating);
        return rating;
       
      

        

    }

    /*public List<TopRatedTrailsResponse> getTopRated()
    {
        return ratingrepo.findTopRatedTrails();

        
    }*/
    

    public ArrayList<TrailRatingsByNameResponse> findByTrailname(String name)
    {
        List<TrailRating> returnedList = ratingrepo.findTrailRatingsByName(name);
        ArrayList<TrailRatingsByNameResponse> responseList = new ArrayList<>();

        for(int count = 0; count < returnedList.size(); count++)
        {
            TrailRatingsByNameResponse trailResponse = new TrailRatingsByNameResponse(returnedList.get(count).getRating(), returnedList.get(count).getComment());
            responseList.add(trailResponse);
        }

        return responseList;
    }

}
