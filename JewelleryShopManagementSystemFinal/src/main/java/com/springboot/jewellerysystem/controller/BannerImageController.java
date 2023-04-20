package com.springboot.jewellerysystem.controller;

import com.springboot.jewellerysystem.entity.BannerImage; 
import com.springboot.jewellerysystem.service.BannerService; 
import com.springboot.jewellerysystem.service.BannerImageService; 
import com.springboot.jewellerysystem.entity.Banner;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.PathVariable;import java.util.List; 
@Controller 
@RequestMapping(value = "bannerImage") 
public class BannerImageController { 
 private BannerImageService bannerImageService; 
 private BannerService bannerService; 
    public BannerImageController(BannerImageService bannerImageService,BannerService bannerService ) { 
        this.bannerImageService = bannerImageService; 
        this.bannerService = bannerService; 
    }
 
    @GetMapping(value = "/index") 
    public String bannerImages(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) { 
        List<BannerImage> bannerImages = bannerImageService.getAllBannerImage(); 
        model.addAttribute("listBannerImages", bannerImages); 
        model.addAttribute("keyword", keyword); 
        return "admin/list/bannerImages_list"; 
    }
 
  @GetMapping(value = "/create") 
    public String formBannerImages(Model model) { 
        model.addAttribute("bannerImage", new BannerImage()); 
List<Banner> banners = bannerService.getAllBanner(); 
model.addAttribute("listBanners", banners); 

        return "admin/entry/bannerImage_entry"; 
    } 
    @GetMapping(value = "/delete/{id}") 
    public String deleteBannerImage(@PathVariable(value= "id")Integer id, String keyword) { 
        bannerImageService.removeBannerImage(id); 
        return "redirect:/bannerImage/index?keyword=" + keyword; 
    }
 
    @GetMapping(value = "/update/{id}") 
    public String updateBannerImage(@PathVariable(value="id") Integer id, Model model) { 
        BannerImage bannerImage = bannerImageService.loadBannerImageById(id); 
        model.addAttribute("bannerImage", bannerImage); 
List<Banner> banners = bannerService.getAllBanner(); 
model.addAttribute("listBanners", banners); 

        return "admin/edit/bannerImage_update"; 
    }
 
    @PostMapping(value = "/save") 
    public String save(BannerImage bannerImage) { 
        bannerImageService.createOrUpdateBannerImage(bannerImage); 
        return "redirect:/bannerImage/index"; 
    }
 
} 
