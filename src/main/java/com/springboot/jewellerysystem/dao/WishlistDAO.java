package com.springboot.jewellerysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.Wishlist;

public interface WishlistDAO extends JpaRepository<Wishlist, Integer> { 

} 
