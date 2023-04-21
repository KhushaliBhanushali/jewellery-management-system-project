package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.Brand;
import java.util.List;

public interface BrandService { 

  List<Brand> getAllBrand();

Brand loadBrandById(Integer id );

Brand createOrUpdateBrand(Brand brand);

void removeBrand(Integer id);

} 
