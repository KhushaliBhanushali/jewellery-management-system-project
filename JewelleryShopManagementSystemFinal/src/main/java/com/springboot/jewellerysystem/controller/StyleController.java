package com.springboot.jewellerysystem.controller;

import com.springboot.jewellerysystem.entity.Style; 
import com.springboot.jewellerysystem.service.StyleService; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.PathVariable;import java.util.List; 
@Controller 
@RequestMapping(value = "style") 
public class StyleController { 
 private StyleService styleService; 
    public StyleController(StyleService styleService) { 
        this.styleService = styleService; 
    }
 
    @GetMapping(value = "/index") 
    public String styles(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) { 
        List<Style> styles = styleService.getAllStyle(); 
        model.addAttribute("listStyles", styles); 
        model.addAttribute("keyword", keyword); 
        return "admin/list/styles_list"; 
    }
 
  @GetMapping(value = "/create") 
    public String formStyles(Model model) { 
        model.addAttribute("style", new Style()); 
        return "admin/entry/style_entry"; 
    } 
    @GetMapping(value = "/delete/{id}") 
    public String deleteStyle(@PathVariable(value= "id")Integer id, String keyword) { 
        styleService.removeStyle(id); 
        return "redirect:/style/index?keyword=" + keyword; 
    }
 
    @GetMapping(value = "/update/{id}") 
    public String updateStyle(@PathVariable(value="id") Integer id, Model model) { 
        Style style = styleService.loadStyleById(id); 
        model.addAttribute("style", style); 
        return "admin/edit/style_update"; 
    }
 
    @PostMapping(value = "/save") 
    public String save(Style style) { 
        styleService.createOrUpdateStyle(style); 
        return "redirect:/style/index"; 
    }
 
} 
