package com.revature.hikingbuddy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.hikingbuddy.entities.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, String>{

    public Product getProductById();

    public void addProduct();

    public void removeProduct();

    public List<Product> getAllProducts();
    
}
