package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.OurService;
import java.util.List;

public interface OurServiceService { 

  List<OurService> getAllOurService();

OurService loadOurServiceById(Integer id );

OurService createOrUpdateOurService(OurService ourService);

void removeOurService(Integer id);

} 
