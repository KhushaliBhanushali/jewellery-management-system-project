package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.Category;
import java.util.List;

public interface CategoryService { 

  List<Category> getAllCategory();

Category loadCategoryById(Integer id );

Category createOrUpdateCategory(Category category);

void removeCategory(Integer id);

} 
