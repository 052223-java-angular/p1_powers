package com.revature.hikingbuddy.entities;


import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

    @Id
    private String Name;
    @Column
    private int numTrails;

    @JsonManagedReference
    @OneToMany(mappedBy = "country_name", fetch = FetchType.LAZY)
    private Set<Trail> trailName;

    
    
}
