package com.springboot.jewellerysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.Style;

public interface StyleDAO extends JpaRepository<Style, Integer> { 

} 
