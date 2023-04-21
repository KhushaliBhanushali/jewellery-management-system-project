package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.Country;
import java.util.List;

public interface CountryService { 

  List<Country> getAllCountry();

Country loadCountryById(Integer id );

Country createOrUpdateCountry(Country country);

void removeCountry(Integer id);

} 
