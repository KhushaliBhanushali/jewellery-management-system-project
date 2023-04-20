package com.springboot.jewellerysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> { 

} 
