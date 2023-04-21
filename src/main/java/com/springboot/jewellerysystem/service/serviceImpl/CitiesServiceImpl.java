package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.CitiesDAO; 
import com.springboot.jewellerysystem.entity.Cities; 
import com.springboot.jewellerysystem.service.CitiesService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CitiesServiceImpl implements CitiesService { 

@Autowired
 private CitiesDAO citiesDao;
 
 @Override 
    public List<Cities> getAllCities() { 
        return citiesDao.findAll(); 
    } 

@Override 
  public Cities loadCitiesById(Integer id) {
 return citiesDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Cities with ID " + id + " Not Found"));
 }

@Override 
    public Cities createOrUpdateCities(Cities cities) {
return citiesDao.save(cities);
   }

  @Override
 	    public void removeCities(Integer id) {
 	        citiesDao.deleteById(id);
 	    }

}
