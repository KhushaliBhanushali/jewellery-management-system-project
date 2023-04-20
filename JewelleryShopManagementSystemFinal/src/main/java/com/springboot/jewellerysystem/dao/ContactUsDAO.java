package com.springboot.jewellerysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.ContactUs;

public interface ContactUsDAO extends JpaRepository<ContactUs, Integer> { 

} 
