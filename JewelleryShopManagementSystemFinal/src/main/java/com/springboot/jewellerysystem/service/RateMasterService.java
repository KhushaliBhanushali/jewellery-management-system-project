package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.RateMaster;
import java.util.List;

public interface RateMasterService { 

  List<RateMaster> getAllRateMaster();

RateMaster loadRateMasterById(Integer id );

RateMaster createOrUpdateRateMaster(RateMaster rateMaster);

void removeRateMaster(Integer id);

} 
