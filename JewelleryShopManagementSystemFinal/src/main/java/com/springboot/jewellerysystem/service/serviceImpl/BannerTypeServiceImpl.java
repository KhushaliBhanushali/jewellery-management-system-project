package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.BannerTypeDAO; 
import com.springboot.jewellerysystem.entity.BannerType; 
import com.springboot.jewellerysystem.service.BannerTypeService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BannerTypeServiceImpl implements BannerTypeService { 

@Autowired
 private BannerTypeDAO bannerTypeDao;
 
 @Override 
    public List<BannerType> getAllBannerType() { 
        return bannerTypeDao.findAll(); 
    } 

@Override 
  public BannerType loadBannerTypeById(Integer id) {
 return bannerTypeDao.findById(id).orElseThrow(() -> new EntityNotFoundException("BannerType with ID " + id + " Not Found"));
 }

@Override 
    public BannerType createOrUpdateBannerType(BannerType bannerType) {
return bannerTypeDao.save(bannerType);
   }

  @Override
 	    public void removeBannerType(Integer id) {
 	        bannerTypeDao.deleteById(id);
 	    }

}
