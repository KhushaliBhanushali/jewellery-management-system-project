package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.Style;
import java.util.List;

public interface StyleService { 

  List<Style> getAllStyle();

Style loadStyleById(Integer id );

Style createOrUpdateStyle(Style style);

void removeStyle(Integer id);

} 
