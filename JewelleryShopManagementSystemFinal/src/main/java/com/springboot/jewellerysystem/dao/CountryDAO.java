package com.springboot.jewellerysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.Country;

public interface CountryDAO extends JpaRepository<Country, Integer> { 

} 
