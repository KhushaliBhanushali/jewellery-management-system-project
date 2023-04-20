package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.RateMasterDAO; 
import com.springboot.jewellerysystem.entity.RateMaster; 
import com.springboot.jewellerysystem.service.RateMasterService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RateMasterServiceImpl implements RateMasterService { 

@Autowired
 private RateMasterDAO rateMasterDao;
 
 @Override 
    public List<RateMaster> getAllRateMaster() { 
        return rateMasterDao.findAll(); 
    } 

@Override 
  public RateMaster loadRateMasterById(Integer id) {
 return rateMasterDao.findById(id).orElseThrow(() -> new EntityNotFoundException("RateMaster with ID " + id + " Not Found"));
 }

@Override 
    public RateMaster createOrUpdateRateMaster(RateMaster rateMaster) {
return rateMasterDao.save(rateMaster);
   }

  @Override
 	    public void removeRateMaster(Integer id) {
 	        rateMasterDao.deleteById(id);
 	    }

}
