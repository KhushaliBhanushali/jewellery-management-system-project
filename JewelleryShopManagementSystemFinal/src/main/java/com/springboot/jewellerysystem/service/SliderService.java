package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.Slider;
import java.util.List;

public interface SliderService { 

  List<Slider> getAllSlider();

Slider loadSliderById(Integer id );

Slider createOrUpdateSlider(Slider slider);

void removeSlider(Integer id);

} 
