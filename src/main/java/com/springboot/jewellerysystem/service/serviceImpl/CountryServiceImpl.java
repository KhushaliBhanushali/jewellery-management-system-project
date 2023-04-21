package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.CountryDAO; 
import com.springboot.jewellerysystem.entity.Country; 
import com.springboot.jewellerysystem.service.CountryService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CountryServiceImpl implements CountryService { 

@Autowired
 private CountryDAO countryDao;
 
 @Override 
    public List<Country> getAllCountry() { 
        return countryDao.findAll(); 
    } 

@Override 
  public Country loadCountryById(Integer id) {
 return countryDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Country with ID " + id + " Not Found"));
 }

@Override 
    public Country createOrUpdateCountry(Country country) {
return countryDao.save(country);
   }

  @Override
 	    public void removeCountry(Integer id) {
 	        countryDao.deleteById(id);
 	    }

}
