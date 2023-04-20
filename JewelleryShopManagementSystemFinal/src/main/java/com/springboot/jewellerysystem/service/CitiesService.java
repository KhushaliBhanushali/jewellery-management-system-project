package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.Cities;
import java.util.List;

public interface CitiesService { 

  List<Cities> getAllCities();

Cities loadCitiesById(Integer id );

Cities createOrUpdateCities(Cities cities);

void removeCities(Integer id);

} 
