package com.springboot.jewellerysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.Brand;

public interface BrandDAO extends JpaRepository<Brand, Integer> { 

} 
