package com.springboot.jewellerysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.BlogCategory;

public interface BlogCategoryDAO extends JpaRepository<BlogCategory, Integer> { 

} 
