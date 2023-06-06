package com.revature.hikingbuddy.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class Roles {

@Id
@JsonManagedReference
private String id;
private String type;

    
}
