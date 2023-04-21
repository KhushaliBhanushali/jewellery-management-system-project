package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.TodayRate;
import java.util.List;

public interface TodayRateService { 

  List<TodayRate> getAllTodayRate();

TodayRate loadTodayRateById(Integer id );

TodayRate createOrUpdateTodayRate(TodayRate todayRate);

void removeTodayRate(Integer id);

} 
