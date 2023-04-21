package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.BlogCategoryDAO; 
import com.springboot.jewellerysystem.entity.BlogCategory; 
import com.springboot.jewellerysystem.service.BlogCategoryService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BlogCategoryServiceImpl implements BlogCategoryService { 

@Autowired
 private BlogCategoryDAO blogCategoryDao;
 
 @Override 
    public List<BlogCategory> getAllBlogCategory() { 
        return blogCategoryDao.findAll(); 
    } 

@Override 
  public BlogCategory loadBlogCategoryById(Integer id) {
 return blogCategoryDao.findById(id).orElseThrow(() -> new EntityNotFoundException("BlogCategory with ID " + id + " Not Found"));
 }

@Override 
    public BlogCategory createOrUpdateBlogCategory(BlogCategory blogCategory) {
return blogCategoryDao.save(blogCategory);
   }

  @Override
 	    public void removeBlogCategory(Integer id) {
 	        blogCategoryDao.deleteById(id);
 	    }

}
