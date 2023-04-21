package com.springboot.jewellerysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.TodayRate;

public interface TodayRateDAO extends JpaRepository<TodayRate, Integer> { 

} 
