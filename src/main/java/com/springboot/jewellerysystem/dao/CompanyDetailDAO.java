package com.springboot.jewellerysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.CompanyDetail;

public interface CompanyDetailDAO extends JpaRepository<CompanyDetail, Integer> { 

} 
