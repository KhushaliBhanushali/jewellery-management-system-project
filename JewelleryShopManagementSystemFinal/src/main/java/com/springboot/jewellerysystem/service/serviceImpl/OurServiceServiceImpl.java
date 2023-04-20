package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.OurServiceDAO; 
import com.springboot.jewellerysystem.entity.OurService; 
import com.springboot.jewellerysystem.service.OurServiceService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OurServiceServiceImpl implements OurServiceService { 

@Autowired
 private OurServiceDAO ourServiceDao;
 
 @Override 
    public List<OurService> getAllOurService() { 
        return ourServiceDao.findAll(); 
    } 

@Override 
  public OurService loadOurServiceById(Integer id) {
 return ourServiceDao.findById(id).orElseThrow(() -> new EntityNotFoundException("OurService with ID " + id + " Not Found"));
 }

@Override 
    public OurService createOrUpdateOurService(OurService ourService) {
return ourServiceDao.save(ourService);
   }

  @Override
 	    public void removeOurService(Integer id) {
 	        ourServiceDao.deleteById(id);
 	    }

}
