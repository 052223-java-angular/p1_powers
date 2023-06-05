package com.revature.hikingbuddy.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cartitems")
public class CartItems {

    @Id
    private String name;

    private String qty_in_cart;

    private double price;

    @ManyToOne
    @Column(nullable = false)
    private Cart cart_id;


    @ManyToOne
    @Column(nullable = false)
    private Product product_id;

    
}
