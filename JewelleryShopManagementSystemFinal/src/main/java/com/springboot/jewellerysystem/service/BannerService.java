package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.Banner;
import java.util.List;

public interface BannerService { 

  List<Banner> getAllBanner();

Banner loadBannerById(Integer id );

Banner createOrUpdateBanner(Banner banner);

void removeBanner(Integer id);

} 
