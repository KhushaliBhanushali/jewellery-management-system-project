package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.MainCategory;
import java.util.List;

public interface MainCategoryService { 

  List<MainCategory> getAllMainCategory();

MainCategory loadMainCategoryById(Integer id );

MainCategory createOrUpdateMainCategory(MainCategory mainCategory);

void removeMainCategory(Integer id);

} 
