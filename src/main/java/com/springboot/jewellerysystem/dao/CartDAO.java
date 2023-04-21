package com.springboot.jewellerysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.Cart;

public interface CartDAO extends JpaRepository<Cart, Integer> { 

} 
