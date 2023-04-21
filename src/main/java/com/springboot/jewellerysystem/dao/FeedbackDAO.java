package com.springboot.jewellerysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.Feedback;

public interface FeedbackDAO extends JpaRepository<Feedback, Integer> { 

} 
