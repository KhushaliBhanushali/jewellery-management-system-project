package com.springboot.jewellerysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.Cities;

public interface CitiesDAO extends JpaRepository<Cities, Integer> { 

} 
