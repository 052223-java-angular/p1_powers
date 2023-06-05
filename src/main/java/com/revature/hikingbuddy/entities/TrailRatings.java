package com.revature.hikingbuddy.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    @Column(nullable = false)
    private Trails trail_name;

    @OneToOne
    @Column(nullable = false)
    private User user_id;
}
