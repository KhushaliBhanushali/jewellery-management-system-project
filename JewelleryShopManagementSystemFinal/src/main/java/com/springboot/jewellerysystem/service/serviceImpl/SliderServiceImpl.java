package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.SliderDAO; 
import com.springboot.jewellerysystem.entity.Slider; 
import com.springboot.jewellerysystem.service.SliderService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SliderServiceImpl implements SliderService { 

@Autowired
 private SliderDAO sliderDao;
 
 @Override 
    public List<Slider> getAllSlider() { 
        return sliderDao.findAll(); 
    } 

@Override 
  public Slider loadSliderById(Integer id) {
 return sliderDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Slider with ID " + id + " Not Found"));
 }

@Override 
    public Slider createOrUpdateSlider(Slider slider) {
return sliderDao.save(slider);
   }

  @Override
 	    public void removeSlider(Integer id) {
 	        sliderDao.deleteById(id);
 	    }

}
