package com.springboot.jewellerysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.Review;

public interface ReviewDAO extends JpaRepository<Review, Integer> { 

} 
