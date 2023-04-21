package com.springboot.jewellerysystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.jewellerysystem.service.BrandService;
import com.springboot.jewellerysystem.service.CategoryService;
import com.springboot.jewellerysystem.service.MainCategoryService;
import com.springboot.jewellerysystem.service.OrderService;
import com.springboot.jewellerysystem.service.ProductService;

@Controller
@RequestMapping(value = "/admin")
public class DashboardController {
	ProductService  productService;
	OrderService orderService;
	MainCategoryService mainCategoryService;
	CategoryService categoryService;
	BrandService brandService;

	public DashboardController(ProductService productService, OrderService orderService,
			MainCategoryService mainCategoryService, CategoryService categoryService, BrandService brandService) {
		super();
		this.productService = productService;
		this.orderService = orderService;
		this.mainCategoryService = mainCategoryService;
		this.categoryService = categoryService;
		this.brandService = brandService;
	}

	@GetMapping()
	public String getDashboard(Model m) {
		
		int p_count =  productService.getAllProduct().size();
		int o_count =  orderService.getAllOrder().size();
		int m_count = mainCategoryService.getAllMainCategory().size();
		int c_count = categoryService.getAllCategory().size();
		int b_count = brandService.getAllBrand().size();
		
		m.addAttribute("product_count",p_count);
		m.addAttribute("order_count",o_count); 
		m.addAttribute("mainCategory_count",m_count);
		m.addAttribute("category_count",c_count);
		m.addAttribute("brand_count",b_count);
		
		return "admin/dashboard";
	}



	
}
