package com.springboot.jewellerysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.MainCategory;

public interface MainCategoryDAO extends JpaRepository<MainCategory, Integer> { 

} 
