package com.springboot.jewellerysystem.controller;

import com.springboot.jewellerysystem.entity.MainCategory; 
import com.springboot.jewellerysystem.service.MainCategoryService;
import com.springboot.jewellerysystem.util.FileUploadUtil;

import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List; 
@Controller 
@RequestMapping(value = "mainCategory") 
public class MainCategoryController { 
 private MainCategoryService mainCategoryService; 
    public MainCategoryController(MainCategoryService mainCategoryService) { 
        this.mainCategoryService = mainCategoryService; 
    }
 
    @GetMapping(value = "/index") 
    public String mainCategories(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) { 
        List<MainCategory> mainCategories = mainCategoryService.getAllMainCategory(); 
        model.addAttribute("listMainCategories", mainCategories); 
        model.addAttribute("keyword", keyword); 
        return "admin/list/mainCategories_list"; 
    }
 
  @GetMapping(value = "/create") 
    public String formMainCategories(Model model) { 
        model.addAttribute("mainCategory", new MainCategory()); 
        return "admin/entry/mainCategory_entry"; 
    } 
    @GetMapping(value = "/delete/{id}") 
    public String deleteMainCategory(@PathVariable(value = "id") Integer id, String keyword) { 
        mainCategoryService.removeMainCategory(id); 
        return "redirect:/mainCategory/index?keyword=" + keyword; 
    }
 
    @GetMapping(value = "/update/{id}") 
    public String updateMainCategory(@PathVariable(value = "id") Integer id, Model model) { 
        MainCategory mainCategory = mainCategoryService.loadMainCategoryById(id); 
        model.addAttribute("mainCategory", mainCategory); 
        return "admin/edit/mainCategory_edit"; 
    }
 
    @PostMapping(value = "/save") 
    public String save(MainCategory mainCategory, @RequestParam("file")MultipartFile file) throws IOException { 
      
    	String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		mainCategory.setImage(fileName);
		String uploadDir = "assets/images/mainCategory";
		FileUploadUtil.saveFile(uploadDir, fileName, file);

    	
    	mainCategoryService.createOrUpdateMainCategory(mainCategory); 
        return "redirect:/mainCategory/index"; 
    }
 
} 
