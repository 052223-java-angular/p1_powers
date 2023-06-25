package com.revature.hikingbuddy.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
public class TopRatedTrailsResponse {
    private String trailName;
    private double avgRating;


}
