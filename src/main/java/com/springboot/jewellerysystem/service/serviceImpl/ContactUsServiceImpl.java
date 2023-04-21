package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.ContactUsDAO; 
import com.springboot.jewellerysystem.entity.ContactUs; 
import com.springboot.jewellerysystem.service.ContactUsService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ContactUsServiceImpl implements ContactUsService { 

@Autowired
 private ContactUsDAO contactUsDao;
 
 @Override 
    public List<ContactUs> getAllContactUs() { 
        return contactUsDao.findAll(); 
    } 

@Override 
  public ContactUs loadContactUsById(Integer id) {
 return contactUsDao.findById(id).orElseThrow(() -> new EntityNotFoundException("ContactUs with ID " + id + " Not Found"));
 }

@Override 
    public ContactUs createOrUpdateContactUs(ContactUs contactUs) {
return contactUsDao.save(contactUs);
   }

  @Override
 	    public void removeContactUs(Integer id) {
 	        contactUsDao.deleteById(id);
 	    }

}
