package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.BannerType;
import java.util.List;

public interface BannerTypeService { 

  List<BannerType> getAllBannerType();

BannerType loadBannerTypeById(Integer id );

BannerType createOrUpdateBannerType(BannerType bannerType);

void removeBannerType(Integer id);

} 
