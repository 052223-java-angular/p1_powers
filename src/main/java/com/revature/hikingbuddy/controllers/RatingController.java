package com.revature.hikingbuddy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.hikingbuddy.dtos.requests.NewRatingRequest;
import com.revature.hikingbuddy.entities.TrailRating;
import com.revature.hikingbuddy.services.RatingService;

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
        this.ratingservice = ratingservice;
    }

    //This method saves the rating to the database so that it can be displayed later
    @PostMapping("/post")
    public ResponseEntity<?> createRating(@RequestBody NewRatingRequest rq)
    {
        TrailRating rating = ratingservice.saveRating(rq);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
}
