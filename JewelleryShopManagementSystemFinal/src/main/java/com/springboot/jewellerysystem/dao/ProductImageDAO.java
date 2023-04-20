package com.springboot.jewellerysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.ProductImage;

public interface ProductImageDAO extends JpaRepository<ProductImage, Integer> { 

} 
