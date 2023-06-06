package com.revature.hikingbuddy.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="trail_rating")
public class TrailRatings {
    @Id
    private String id;
    private double rating;
    private String comment;
 
    @ManyToOne
    @JoinColumn(name = "trail_name")
    @JsonBackReference
    private Trails trail_name;

    @ManyToOne
    @JoinColumn(name = "user.id")
    @JsonBackReference
    private User user_id;
}
