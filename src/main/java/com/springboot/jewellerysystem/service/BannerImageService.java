package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.BannerImage;
import java.util.List;

public interface BannerImageService { 

  List<BannerImage> getAllBannerImage();

BannerImage loadBannerImageById(Integer id );

BannerImage createOrUpdateBannerImage(BannerImage bannerImage);

void removeBannerImage(Integer id);

} 
