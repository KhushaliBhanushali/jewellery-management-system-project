package com.springboot.jewellerysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.BannerType;

public interface BannerTypeDAO extends JpaRepository<BannerType, Integer> { 

} 
