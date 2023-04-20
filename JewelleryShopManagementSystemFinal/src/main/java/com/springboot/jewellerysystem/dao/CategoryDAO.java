package com.springboot.jewellerysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> { 

} 
