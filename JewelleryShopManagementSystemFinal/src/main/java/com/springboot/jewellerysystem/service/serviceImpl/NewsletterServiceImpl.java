package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.NewsletterDAO; 
import com.springboot.jewellerysystem.entity.Newsletter; 
import com.springboot.jewellerysystem.service.NewsletterService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class NewsletterServiceImpl implements NewsletterService { 

@Autowired
 private NewsletterDAO newsletterDao;
 
 @Override 
    public List<Newsletter> getAllNewsletter() { 
        return newsletterDao.findAll(); 
    } 

@Override 
  public Newsletter loadNewsletterById(Integer id) {
 return newsletterDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Newsletter with ID " + id + " Not Found"));
 }

@Override 
    public Newsletter createOrUpdateNewsletter(Newsletter newsletter) {
return newsletterDao.save(newsletter);
   }

  @Override
 	    public void removeNewsletter(Integer id) {
 	        newsletterDao.deleteById(id);
 	    }

}
