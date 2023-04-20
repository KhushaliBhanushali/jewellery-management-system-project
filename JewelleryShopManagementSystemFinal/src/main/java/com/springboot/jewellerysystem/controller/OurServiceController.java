package com.springboot.jewellerysystem.controller;

import com.springboot.jewellerysystem.entity.OurService; 
import com.springboot.jewellerysystem.service.OurServiceService; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.PathVariable;import java.util.List; 
@Controller 
@RequestMapping(value = "ourService") 
public class OurServiceController { 
 private OurServiceService ourServiceService; 
    public OurServiceController(OurServiceService ourServiceService) { 
        this.ourServiceService = ourServiceService; 
    }
 
    @GetMapping(value = "/index") 
    public String ourServices(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) { 
        List<OurService> ourServices = ourServiceService.getAllOurService(); 
        model.addAttribute("listOurServices", ourServices); 
        model.addAttribute("keyword", keyword); 
        return "admin/list/ourServices_list"; 
    }
 
  @GetMapping(value = "/create") 
    public String formOurServices(Model model) { 
        model.addAttribute("ourService", new OurService()); 
        return "admin/entry/ourService_entry"; 
    } 
    @GetMapping(value = "/delete/{id}") 
    public String deleteOurService(@PathVariable(value= "id")Integer id, String keyword) { 
        ourServiceService.removeOurService(id); 
        return "redirect:/ourService/index?keyword=" + keyword; 
    }
 
    @GetMapping(value = "/update/{id}") 
    public String updateOurService(@PathVariable(value="id") Integer id, Model model) { 
        OurService ourService = ourServiceService.loadOurServiceById(id); 
        model.addAttribute("ourService", ourService); 
        return "admin/edit/ourService_update"; 
    }
 
    @PostMapping(value = "/save") 
    public String save(OurService ourService) { 
        ourServiceService.createOrUpdateOurService(ourService); 
        return "redirect:/ourService/index"; 
    }
 
} 
