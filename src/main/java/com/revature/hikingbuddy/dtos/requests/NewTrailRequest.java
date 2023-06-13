package com.revature.hikingbuddy.dtos.requests;

import com.revature.hikingbuddy.entities.Country;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class NewTrailRequest {
    private String name;
    private double trailLength;
    private String country_name;

    
}
