package com.springboot.jewellerysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.springboot.jewellerysystem.entity.Language;

public interface LanguageDAO extends JpaRepository<Language, Integer> { 

} 
