package com.springboot.jewellerysystem.controller;

import com.springboot.jewellerysystem.entity.BannerType; 
import com.springboot.jewellerysystem.service.BannerTypeService; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam; 
import java.util.List; 
@Controller 
@RequestMapping(value = "admin/bannerType") 
public class BannerTypeController { 
 private BannerTypeService bannerTypeService; 
    public BannerTypeController(BannerTypeService bannerTypeService) { 
        this.bannerTypeService = bannerTypeService; 
    }
 
    @GetMapping(value = "/index") 
    public String bannerTypes(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) { 
        List<BannerType> bannerTypes = bannerTypeService.getAllBannerType(); 
        model.addAttribute("listBannerTypes", bannerTypes); 
        model.addAttribute("keyword", keyword); 
        return "admin/list/bannerTypes_list"; 
    }
 
  @GetMapping(value = "/create") 
    public String formBannerTypes(Model model) { 
        model.addAttribute("bannerType", new BannerType()); 
        return "admin/entry/bannerType_entry"; 
    } 
    @GetMapping(value = "/delete/{id}") 
    public String deleteBannerType(@PathVariable(value = "id") Integer id, String keyword) { 
        bannerTypeService.removeBannerType(id); 
        return "redirect:/admin/bannerType/index?keyword=" + keyword; 
    }
 
    @GetMapping(value = "/update/{id}") 
    public String updateBannerType(@PathVariable(value = "id") Integer id, Model model) { 
        BannerType bannerType = bannerTypeService.loadBannerTypeById(id); 
        model.addAttribute("bannerType", bannerType); 
        return "admin/edit/bannerType_edit"; 
    }
 
    @PostMapping(value = "/save") 
    public String save(BannerType bannerType) { 
        bannerTypeService.createOrUpdateBannerType(bannerType); 
        return "redirect:/admin/bannerType/index"; 
    }
 
} 
