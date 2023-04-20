package com.springboot.jewellerysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.Faq;

public interface FaqDAO extends JpaRepository<Faq, Integer> { 

} 
