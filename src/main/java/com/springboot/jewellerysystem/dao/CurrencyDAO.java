package com.springboot.jewellerysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.Currency;

public interface CurrencyDAO extends JpaRepository<Currency, Integer> { 

} 
