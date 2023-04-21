package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.StyleDAO; 
import com.springboot.jewellerysystem.entity.Style; 
import com.springboot.jewellerysystem.service.StyleService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StyleServiceImpl implements StyleService { 

@Autowired
 private StyleDAO styleDao;
 
 @Override 
    public List<Style> getAllStyle() { 
        return styleDao.findAll(); 
    } 

@Override 
  public Style loadStyleById(Integer id) {
 return styleDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Style with ID " + id + " Not Found"));
 }

@Override 
    public Style createOrUpdateStyle(Style style) {
return styleDao.save(style);
   }

  @Override
 	    public void removeStyle(Integer id) {
 	        styleDao.deleteById(id);
 	    }

}
