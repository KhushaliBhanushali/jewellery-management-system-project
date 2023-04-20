package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.MainCategoryDAO; 
import com.springboot.jewellerysystem.entity.MainCategory; 
import com.springboot.jewellerysystem.service.MainCategoryService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MainCategoryServiceImpl implements MainCategoryService { 

@Autowired
 private MainCategoryDAO mainCategoryDao;
 
 @Override 
    public List<MainCategory> getAllMainCategory() { 
        return mainCategoryDao.findAll(); 
    } 

@Override 
  public MainCategory loadMainCategoryById(Integer id) {
 return mainCategoryDao.findById(id).orElseThrow(() -> new EntityNotFoundException("MainCategory with ID " + id + " Not Found"));
 }

@Override 
    public MainCategory createOrUpdateMainCategory(MainCategory mainCategory) {
return mainCategoryDao.save(mainCategory);
   }

  @Override
 	    public void removeMainCategory(Integer id) {
 	        mainCategoryDao.deleteById(id);
 	    }

}
