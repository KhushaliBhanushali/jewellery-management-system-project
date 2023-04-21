package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.TodayRateDAO; 
import com.springboot.jewellerysystem.entity.TodayRate; 
import com.springboot.jewellerysystem.service.TodayRateService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TodayRateServiceImpl implements TodayRateService { 

@Autowired
 private TodayRateDAO todayRateDao;
 
 @Override 
    public List<TodayRate> getAllTodayRate() { 
        return todayRateDao.findAll(); 
    } 

@Override 
  public TodayRate loadTodayRateById(Integer id) {
 return todayRateDao.findById(id).orElseThrow(() -> new EntityNotFoundException("TodayRate with ID " + id + " Not Found"));
 }

@Override 
    public TodayRate createOrUpdateTodayRate(TodayRate todayRate) {
return todayRateDao.save(todayRate);
   }

  @Override
 	    public void removeTodayRate(Integer id) {
 	        todayRateDao.deleteById(id);
 	    }

}
