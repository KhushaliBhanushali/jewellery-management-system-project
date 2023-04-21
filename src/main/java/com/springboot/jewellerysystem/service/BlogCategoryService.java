package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.BlogCategory;
import java.util.List;

public interface BlogCategoryService { 

  List<BlogCategory> getAllBlogCategory();

BlogCategory loadBlogCategoryById(Integer id );

BlogCategory createOrUpdateBlogCategory(BlogCategory blogCategory);

void removeBlogCategory(Integer id);

} 
