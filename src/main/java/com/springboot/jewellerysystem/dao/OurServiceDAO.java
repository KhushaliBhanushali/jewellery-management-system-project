package com.springboot.jewellerysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.OurService;

public interface OurServiceDAO extends JpaRepository<OurService, Integer> { 

} 
