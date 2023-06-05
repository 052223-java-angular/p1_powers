package com.revature.hikingbuddy.entities;

import jakarta.persistence.Id;

public class Product {
    @Id
    private String id;

    private String name;

    private int quantity;

    private double price;
}
