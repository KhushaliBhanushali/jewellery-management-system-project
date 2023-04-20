package com.springboot.jewellerysystem.controller;

import com.springboot.jewellerysystem.entity.CompanyDetail; 
import com.springboot.jewellerysystem.service.CompanyDetailService; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.PathVariable;import java.util.List; 
@Controller 
@RequestMapping(value = "companyDetail") 
public class CompanyDetailController { 
 private CompanyDetailService companyDetailService; 
    public CompanyDetailController(CompanyDetailService companyDetailService) { 
        this.companyDetailService = companyDetailService; 
    }
 
    @GetMapping(value = "/index") 
    public String companyDetails(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) { 
        List<CompanyDetail> companyDetails = companyDetailService.getAllCompanyDetail(); 
        model.addAttribute("listCompanyDetails", companyDetails); 
        model.addAttribute("keyword", keyword); 
        return "admin/list/companyDetails_list"; 
    }
 
  @GetMapping(value = "/create") 
    public String formCompanyDetails(Model model) { 
        model.addAttribute("companyDetail", new CompanyDetail()); 
        return "admin/entry/companyDetail_entry"; 
    } 
    @GetMapping(value = "/delete/{id}") 
    public String deleteCompanyDetail(@PathVariable(value= "id")Integer id, String keyword) { 
        companyDetailService.removeCompanyDetail(id); 
        return "redirect:/companyDetail/index?keyword=" + keyword; 
    }
 
    @GetMapping(value = "/update/{id}") 
    public String updateCompanyDetail(@PathVariable(value="id") Integer id, Model model) { 
        CompanyDetail companyDetail = companyDetailService.loadCompanyDetailById(id); 
        model.addAttribute("companyDetail", companyDetail); 
        return "admin/edit/companyDetail_update"; 
    }
 
    @PostMapping(value = "/save") 
    public String save(CompanyDetail companyDetail) { 
        companyDetailService.createOrUpdateCompanyDetail(companyDetail); 
        return "redirect:/companyDetail/index"; 
    }
 
} 
