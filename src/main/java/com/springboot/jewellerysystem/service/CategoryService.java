package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.Category;
import com.springboot.jewellerysystem.entity.MainCategory;

import java.util.List;

public interface CategoryService {

	List<Category> getAllCategory();
	
	List<Category> getAllCategoryByMainCategory(MainCategory mainCategory);

	Category loadCategoryById(Integer id);

	Category createOrUpdateCategory(Category category);

	void removeCategory(Integer id);
	

}
