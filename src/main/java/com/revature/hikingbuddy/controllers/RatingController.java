package com.revature.hikingbuddy.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.hikingbuddy.dtos.requests.GetTrailRatingsByNameRequest;
import com.revature.hikingbuddy.dtos.requests.NewRatingRequest;
import com.revature.hikingbuddy.dtos.responses.TopRatedTrailsResponse;
import com.revature.hikingbuddy.dtos.responses.TrailRatingsByNameResponse;
import com.revature.hikingbuddy.entities.TrailRating;
import com.revature.hikingbuddy.services.RatingService;
import com.revature.hikingbuddy.services.UserService;

@CrossOrigin(origins="http://localhost:4200",exposedHeaders="Access-Control-Allow-Origin")
@RestController
@RequestMapping("/ratings")
public class RatingController {
    /*
     * This class is another controller class that is called whenever the user wants to leave a rating on a trail that 
     * they have hiked
     */
    private RatingService ratingservice;

    @Autowired
    private RatingController(RatingService ratingservice)
    {
        System.out.println("In ratingController constructor");
        this.ratingservice = ratingservice;
    }

    //This method saves the rating to the database so that it can be displayed later
    @PostMapping("/post")
    public ResponseEntity<?> createRating(@RequestBody NewRatingRequest rq)
    {
        System.out.println("Posting. . .");
        System.out.println("trailName in createRating:" + rq.getTrailName());
        TrailRating rating = ratingservice.saveRating(rq);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating);
    }

    /*@GetMapping("/getTop")
    public ResponseEntity<?> getTopRated()
    {   
        //List<TopRatedTrailsResponse> topRated = ratingservice.getTopRated();
        return ResponseEntity.status(HttpStatus.OK).body(topRated);
    }*/
    
    @PostMapping("/getByName")
    public ResponseEntity<?> getRatingsByTrailName(@RequestBody GetTrailRatingsByNameRequest rq)
    {
        ArrayList<TrailRatingsByNameResponse> trailRatings = ratingservice.findByTrailname(rq.getTrailName());
        /*for(int count = 0; count < trailRatings.size(); count++)
        {
            System.out.println("Rating: " + trailRatings.get(count).getRating());
            System.out.println("Comment: " + trailRatings.get(count).getComment());
        }*/
        return ResponseEntity.status(HttpStatus.OK).body(trailRatings);
    }
}
