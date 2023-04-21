package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.FaqDAO; 
import com.springboot.jewellerysystem.entity.Faq; 
import com.springboot.jewellerysystem.service.FaqService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FaqServiceImpl implements FaqService { 

@Autowired
 private FaqDAO faqDao;
 
 @Override 
    public List<Faq> getAllFaq() { 
        return faqDao.findAll(); 
    } 

@Override 
  public Faq loadFaqById(Integer id) {
 return faqDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Faq with ID " + id + " Not Found"));
 }

@Override 
    public Faq createOrUpdateFaq(Faq faq) {
return faqDao.save(faq);
   }

  @Override
 	    public void removeFaq(Integer id) {
 	        faqDao.deleteById(id);
 	    }

}
