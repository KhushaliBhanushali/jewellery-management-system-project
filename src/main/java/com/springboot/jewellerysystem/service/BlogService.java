package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.Blog;
import java.util.List;

public interface BlogService { 

  List<Blog> getAllBlog();

Blog loadBlogById(Integer id );

Blog createOrUpdateBlog(Blog blog);

void removeBlog(Integer id);

} 
