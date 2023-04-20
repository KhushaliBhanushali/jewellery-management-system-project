package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.BannerImageDAO; 
import com.springboot.jewellerysystem.entity.BannerImage; 
import com.springboot.jewellerysystem.service.BannerImageService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BannerImageServiceImpl implements BannerImageService { 

@Autowired
 private BannerImageDAO bannerImageDao;
 
 @Override 
    public List<BannerImage> getAllBannerImage() { 
        return bannerImageDao.findAll(); 
    } 

@Override 
  public BannerImage loadBannerImageById(Integer id) {
 return bannerImageDao.findById(id).orElseThrow(() -> new EntityNotFoundException("BannerImage with ID " + id + " Not Found"));
 }

@Override 
    public BannerImage createOrUpdateBannerImage(BannerImage bannerImage) {
return bannerImageDao.save(bannerImage);
   }

  @Override
 	    public void removeBannerImage(Integer id) {
 	        bannerImageDao.deleteById(id);
 	    }

}
