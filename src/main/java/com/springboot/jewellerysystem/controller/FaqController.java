package com.springboot.jewellerysystem.controller;

import com.springboot.jewellerysystem.entity.Faq; 
import com.springboot.jewellerysystem.service.FaqService; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam; 
import java.util.List; 
@Controller 
@RequestMapping(value = "admin/faq") 
public class FaqController { 
 private FaqService faqService; 
    public FaqController(FaqService faqService) { 
        this.faqService = faqService; 
    }
 
    @GetMapping(value = "/index") 
    public String faqs(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) { 
        List<Faq> faqs = faqService.getAllFaq(); 
        model.addAttribute("listFaqs", faqs); 
        model.addAttribute("keyword", keyword); 
        return "admin/list/faqs_list"; 
    }
 
  @GetMapping(value = "/create") 
    public String formFaqs(Model model) { 
        model.addAttribute("faq", new Faq()); 
        return "admin/entry/faq_entry"; 
    } 
    @GetMapping(value = "/delete/{id}") 
    public String deleteFaq(@PathVariable(value = "id") Integer id, String keyword) { 
        faqService.removeFaq(id); 
        return "redirect:/admin/faq/index?keyword=" + keyword; 
    }
 
    @GetMapping(value = "/update/{id}") 
    public String updateFaq(@PathVariable(value = "id") Integer id, Model model) { 
        Faq faq = faqService.loadFaqById(id); 
        model.addAttribute("faq", faq); 
        return "admin/edit/faq_edit"; 
    }
 
    @PostMapping(value = "/save") 
    public String save(Faq faq) { 
        faqService.createOrUpdateFaq(faq); 
        return "redirect:/admin/faq/index"; 
    }
 
} 
