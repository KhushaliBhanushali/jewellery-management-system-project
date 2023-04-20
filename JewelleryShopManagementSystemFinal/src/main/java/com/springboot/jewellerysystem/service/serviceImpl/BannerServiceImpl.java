package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.BannerDAO; 
import com.springboot.jewellerysystem.entity.Banner; 
import com.springboot.jewellerysystem.service.BannerService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BannerServiceImpl implements BannerService { 

@Autowired
 private BannerDAO bannerDao;
 
 @Override 
    public List<Banner> getAllBanner() { 
        return bannerDao.findAll(); 
    } 

@Override 
  public Banner loadBannerById(Integer id) {
 return bannerDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Banner with ID " + id + " Not Found"));
 }

@Override 
    public Banner createOrUpdateBanner(Banner banner) {
return bannerDao.save(banner);
   }

  @Override
 	    public void removeBanner(Integer id) {
 	        bannerDao.deleteById(id);
 	    }

}
