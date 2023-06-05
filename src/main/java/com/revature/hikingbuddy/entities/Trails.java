package com.revature.hikingbuddy.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "trails")
public class Trails {
    @Id
    private String name;
    private String hasHiked;
    private double avgRating;
    private double trailLength;
    
}
