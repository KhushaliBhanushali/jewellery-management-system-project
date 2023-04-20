package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.LanguageDAO; 
import com.springboot.jewellerysystem.entity.Language; 
import com.springboot.jewellerysystem.service.LanguageService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LanguageServiceImpl implements LanguageService { 

@Autowired
 private LanguageDAO languageDao;
 
 @Override 
    public List<Language> getAllLanguage() { 
        return languageDao.findAll(); 
    } 

@Override 
  public Language loadLanguageById(Integer id) {
 return languageDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Language with ID " + id + " Not Found"));
 }

@Override 
    public Language createOrUpdateLanguage(Language language) {
return languageDao.save(language);
   }

  @Override
 	    public void removeLanguage(Integer id) {
 	        languageDao.deleteById(id);
 	    }

}
