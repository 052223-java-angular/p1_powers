package com.revature.hikingbuddy.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

   @Id
    private String Name;

    private int numTrails;

    
    
}
