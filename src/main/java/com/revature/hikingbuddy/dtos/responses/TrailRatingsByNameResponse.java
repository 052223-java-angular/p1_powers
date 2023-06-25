package com.revature.hikingbuddy.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrailRatingsByNameResponse {
    private double rating;
    private String comment;

     public TrailRatingsByNameResponse(double rating, String comment)
    {
        this.rating = rating;
        this.comment = comment;
    }

    
}
