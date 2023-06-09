package com.revature.hikingbuddy.dtos.requests;

import com.revature.hikingbuddy.entities.Trails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewRatingRequest {

    private String user_id;
    private double rating;
    private String comment;
    private Trails trail_name;

}
