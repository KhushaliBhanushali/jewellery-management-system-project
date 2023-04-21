package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.PagesDAO; 
import com.springboot.jewellerysystem.entity.Pages; 
import com.springboot.jewellerysystem.service.PagesService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PagesServiceImpl implements PagesService { 

@Autowired
 private PagesDAO pagesDao;
 
 @Override 
    public List<Pages> getAllPages() { 
        return pagesDao.findAll(); 
    } 

@Override 
  public Pages loadPagesById(Integer id) {
 return pagesDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Pages with ID " + id + " Not Found"));
 }

@Override 
    public Pages createOrUpdatePages(Pages pages) {
return pagesDao.save(pages);
   }

  @Override
 	    public void removePages(Integer id) {
 	        pagesDao.deleteById(id);
 	    }

}
