package com.springboot.jewellerysystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jewellerysystem.entity.Category;

import com.springboot.jewellerysystem.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> { 

	List<Product> findByCategory(Category category);
} 
