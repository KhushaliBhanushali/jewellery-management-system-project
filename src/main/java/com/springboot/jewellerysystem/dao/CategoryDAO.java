package com.springboot.jewellerysystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.Category;
import com.springboot.jewellerysystem.entity.MainCategory;

public interface CategoryDAO extends JpaRepository<Category, Integer> { 
	
	List<Category> findByMainCategory(MainCategory mainCategory);
	

} 
