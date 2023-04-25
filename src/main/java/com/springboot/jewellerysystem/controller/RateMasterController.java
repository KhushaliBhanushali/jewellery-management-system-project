package com.springboot.jewellerysystem.controller;

import com.springboot.jewellerysystem.entity.RateMaster; 
import com.springboot.jewellerysystem.service.RateMasterService; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam; 
import java.util.List; 
@Controller 
@RequestMapping(value = "admin/rateMaster") 
public class RateMasterController { 
 private RateMasterService rateMasterService; 
    public RateMasterController(RateMasterService rateMasterService) { 
        this.rateMasterService = rateMasterService; 
    }
 
    @GetMapping(value = "/index") 
    public String rateMasters(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) { 
        List<RateMaster> rateMasters = rateMasterService.getAllRateMaster(); 
        model.addAttribute("listRateMasters", rateMasters); 
        model.addAttribute("keyword", keyword); 
        return "admin/list/rateMasters_list"; 
    }
 
  @GetMapping(value = "/create") 
    public String formRateMasters(Model model) { 
        model.addAttribute("rateMaster", new RateMaster()); 
        return "admin/entry/rateMaster_entry"; 
    } 
    @GetMapping(value = "/delete/{id}") 
    public String deleteRateMaster(@PathVariable(value = "id") Integer id, String keyword) { 
        rateMasterService.removeRateMaster(id); 
        return "redirect:/admin/rateMaster/index?keyword=" + keyword; 
    }
 
    @GetMapping(value = "/update/{id}") 
    public String updateRateMaster(@PathVariable(value = "id") Integer id, Model model) { 
        RateMaster rateMaster = rateMasterService.loadRateMasterById(id); 
        model.addAttribute("rateMaster", rateMaster); 
        return "admin/edit/rateMaster_edit"; 
    }
 
    @PostMapping(value = "/save") 
    public String save(RateMaster rateMaster) { 
        rateMasterService.createOrUpdateRateMaster(rateMaster); 
        return "redirect:/admin/rateMaster/index"; 
    }
 
} 
