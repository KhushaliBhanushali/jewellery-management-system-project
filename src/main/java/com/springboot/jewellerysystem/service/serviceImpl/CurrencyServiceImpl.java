package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.CurrencyDAO; 
import com.springboot.jewellerysystem.entity.Currency; 
import com.springboot.jewellerysystem.service.CurrencyService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CurrencyServiceImpl implements CurrencyService { 

@Autowired
 private CurrencyDAO currencyDao;
 
 @Override 
    public List<Currency> getAllCurrency() { 
        return currencyDao.findAll(); 
    } 

@Override 
  public Currency loadCurrencyById(Integer id) {
 return currencyDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Currency with ID " + id + " Not Found"));
 }

@Override 
    public Currency createOrUpdateCurrency(Currency currency) {
return currencyDao.save(currency);
   }

  @Override
 	    public void removeCurrency(Integer id) {
 	        currencyDao.deleteById(id);
 	    }

}
