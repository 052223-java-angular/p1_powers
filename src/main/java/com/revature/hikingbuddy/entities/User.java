package com.revature.hikingbuddy.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @JsonManagedReference
    private String id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

   @ManyToOne
   @JoinColumn(name = "role_id")
   @JsonBackReference
   private Roles role_id;


    
}
