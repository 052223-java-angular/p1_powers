package com.revature.hikingbuddy.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    private String cart_id;

    @OneToOne
    private User user_id;

    
}
