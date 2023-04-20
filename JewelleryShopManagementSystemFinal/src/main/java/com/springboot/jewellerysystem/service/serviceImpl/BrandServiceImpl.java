package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.BrandDAO; 
import com.springboot.jewellerysystem.entity.Brand; 
import com.springboot.jewellerysystem.service.BrandService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BrandServiceImpl implements BrandService { 

@Autowired
 private BrandDAO brandDao;
 
 @Override 
    public List<Brand> getAllBrand() { 
        return brandDao.findAll(); 
    } 

@Override 
  public Brand loadBrandById(Integer id) {
 return brandDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Brand with ID " + id + " Not Found"));
 }

@Override 
    public Brand createOrUpdateBrand(Brand brand) {
return brandDao.save(brand);
   }

  @Override
 	    public void removeBrand(Integer id) {
 	        brandDao.deleteById(id);
 	    }

}
