package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.BlogDAO; 
import com.springboot.jewellerysystem.entity.Blog; 
import com.springboot.jewellerysystem.service.BlogService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BlogServiceImpl implements BlogService { 

@Autowired
 private BlogDAO blogDao;
 
 @Override 
    public List<Blog> getAllBlog() { 
        return blogDao.findAll(); 
    } 

@Override 
  public Blog loadBlogById(Integer id) {
 return blogDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Blog with ID " + id + " Not Found"));
 }

@Override 
    public Blog createOrUpdateBlog(Blog blog) {
return blogDao.save(blog);
   }

  @Override
 	    public void removeBlog(Integer id) {
 	        blogDao.deleteById(id);
 	    }

}
