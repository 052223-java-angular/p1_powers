package com.revature.hikingbuddy.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "trails")
public class Trails {
    @Id
    @JsonManagedReference
    private String name;
    @Column
    private String hasHiked;
    @Column
    private double avgRating;
    @Column
    private double trailLength;

    @ManyToOne
    @JoinColumn(name = "country_name")
    private Country country_name;
    
}
