package com.revature.hikingbuddy.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class Orders {

    @Id
    private String id;

    @OneToOne
    @Column(nullable = false)
    private Cart cart_id;

    private String card_num;

    private double total_price;
    
}
