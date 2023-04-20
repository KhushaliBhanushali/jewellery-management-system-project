package com.springboot.jewellerysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.Banner;

public interface BannerDAO extends JpaRepository<Banner, Integer> { 

} 
