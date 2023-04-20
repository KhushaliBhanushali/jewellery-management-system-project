package com.springboot.jewellerysystem.controller;

import com.springboot.jewellerysystem.entity.Pages; 
import com.springboot.jewellerysystem.service.PagesService; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.PathVariable;import java.util.List; 
@Controller 
@RequestMapping(value = "pages") 
public class PagesController { 
 private PagesService pagesService; 
    public PagesController(PagesService pagesService) { 
        this.pagesService = pagesService; 
    }
 
    @GetMapping(value = "/index") 
    public String pageses(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) { 
        List<Pages> pageses = pagesService.getAllPages(); 
        model.addAttribute("listPageses", pageses); 
        model.addAttribute("keyword", keyword); 
        return "admin/list/pageses_list"; 
    }
 
  @GetMapping(value = "/create") 
    public String formPageses(Model model) { 
        model.addAttribute("pages", new Pages()); 
        return "admin/entry/pages_entry"; 
    } 
    @GetMapping(value = "/delete/{id}") 
    public String deletePages(@PathVariable(value= "id")Integer id, String keyword) { 
        pagesService.removePages(id); 
        return "redirect:/pages/index?keyword=" + keyword; 
    }
 
    @GetMapping(value = "/update/{id}") 
    public String updatePages(@PathVariable(value="id") Integer id, Model model) { 
        Pages pages = pagesService.loadPagesById(id); 
        model.addAttribute("pages", pages); 
        return "admin/edit/pages_update"; 
    }
 
    @PostMapping(value = "/save") 
    public String save(Pages pages) { 
        pagesService.createOrUpdatePages(pages); 
        return "redirect:/pages/index"; 
    }
 
} 
