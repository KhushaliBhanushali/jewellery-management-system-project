package com.springboot.jewellerysystem.controller;

import com.springboot.jewellerysystem.entity.Review; 
import com.springboot.jewellerysystem.service.ProductService; 
import com.springboot.jewellerysystem.service.ReviewService; 
import com.springboot.jewellerysystem.entity.Product;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.PathVariable;import java.util.List; 
@Controller 
@RequestMapping(value = "review") 
public class ReviewController { 
 private ReviewService reviewService; 
 private ProductService productService; 
    public ReviewController(ReviewService reviewService,ProductService productService ) { 
        this.reviewService = reviewService; 
        this.productService = productService; 
    }
 
    @GetMapping(value = "/index") 
    public String reviews(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) { 
        List<Review> reviews = reviewService.getAllReview(); 
        model.addAttribute("listReviews", reviews); 
        model.addAttribute("keyword", keyword); 
        return "admin/list/reviews_list"; 
    }
 
  @GetMapping(value = "/create") 
    public String formReviews(Model model) { 
        model.addAttribute("review", new Review()); 
List<Product> products = productService.getAllProduct(); 
model.addAttribute("listProducts", products); 

        return "admin/entry/review_entry"; 
    } 
    @GetMapping(value = "/delete/{id}") 
    public String deleteReview(@PathVariable(value= "id")Integer id, String keyword) { 
        reviewService.removeReview(id); 
        return "redirect:/review/index?keyword=" + keyword; 
    }
 
    @GetMapping(value = "/update/{id}") 
    public String updateReview(@PathVariable(value="id") Integer id, Model model) { 
        Review review = reviewService.loadReviewById(id); 
        model.addAttribute("review", review); 
List<Product> products = productService.getAllProduct(); 
model.addAttribute("listProducts", products); 

        return "admin/edit/review_update"; 
    }
 
    @PostMapping(value = "/save") 
    public String save(Review review) { 
        reviewService.createOrUpdateReview(review); 
        return "redirect:/review/index"; 
    }
 
} 
