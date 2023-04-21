package com.springboot.jewellerysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.Newsletter;

public interface NewsletterDAO extends JpaRepository<Newsletter, Integer> { 

} 
