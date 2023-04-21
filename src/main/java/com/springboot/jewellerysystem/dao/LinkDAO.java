package com.springboot.jewellerysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.Link;

public interface LinkDAO extends JpaRepository<Link, Integer> { 

} 
