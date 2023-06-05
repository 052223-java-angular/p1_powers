package com.revature.hikingbuddy.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cartitems")
public class CartItems {

    @Id
    private String name;

    private String qty_in_cart;

    private double price;

    @Column(nullable = false)
    @ManyToOne
    private Cart cart_id;

    //@Column(nullable = false)
    @ManyToOne
    @JoinColumn(name = "id")
    private Product product_id;

    
}
