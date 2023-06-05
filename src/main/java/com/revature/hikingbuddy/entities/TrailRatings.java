package com.revature.hikingbuddy.entities;

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

    
   // @Column(nullable = false)
    @ManyToOne
    @JoinColumn(name="name")
    private Trails trail_name;

    @OneToOne
    @Column(nullable = false)
    private User user_id;
}
