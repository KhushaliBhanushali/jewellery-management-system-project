package com.springboot.jewellerysystem.controller;

import com.springboot.jewellerysystem.entity.Newsletter; 
import com.springboot.jewellerysystem.service.NewsletterService; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam; 
import java.util.List; 
@Controller 
@RequestMapping(value = "admin/newsletter") 
public class NewsletterController { 
 private NewsletterService newsletterService; 
    public NewsletterController(NewsletterService newsletterService) { 
        this.newsletterService = newsletterService; 
    }
 
    @GetMapping(value = "/index") 
    public String newsletters(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) { 
        List<Newsletter> newsletters = newsletterService.getAllNewsletter(); 
        model.addAttribute("listNewsletters", newsletters); 
        model.addAttribute("keyword", keyword); 
        return "admin/list/newsletters_list"; 
    }
 
  @GetMapping(value = "/create") 
    public String formNewsletters(Model model) { 
        model.addAttribute("newsletter", new Newsletter()); 
        return "admin/entry/newsletter_entry"; 
    } 
    @GetMapping(value = "/delete/{id}") 
    public String deleteNewsletter(@PathVariable(value = "id") Integer id, String keyword) { 
        newsletterService.removeNewsletter(id); 
        return "redirect:/admin/newsletter/index?keyword=" + keyword; 
    }
 
    @GetMapping(value = "/update/{id}") 
    public String updateNewsletter(@PathVariable(value = "id") Integer id, Model model) { 
        Newsletter newsletter = newsletterService.loadNewsletterById(id); 
        model.addAttribute("newsletter", newsletter); 
        return "admin/edit/newsletter_edit"; 
    }
 
    @PostMapping(value = "/save") 
    public String save(Newsletter newsletter) { 
        newsletterService.createOrUpdateNewsletter(newsletter); 
        return "redirect:/admin/newsletter/index"; 
    }
 
} 
