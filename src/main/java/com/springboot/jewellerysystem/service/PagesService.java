package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.Pages;
import java.util.List;

public interface PagesService { 

  List<Pages> getAllPages();

Pages loadPagesById(Integer id );

Pages createOrUpdatePages(Pages pages);

void removePages(Integer id);

} 
