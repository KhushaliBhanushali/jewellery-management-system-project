package com.springboot.jewellerysystem.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.jewellerysystem.entity.Product;
import com.springboot.jewellerysystem.entity.ProductDetail;
import com.springboot.jewellerysystem.service.ProductDetailService;
import com.springboot.jewellerysystem.service.ProductService;

@Controller
@RequestMapping(value = "productDetail")
public class ProductDetailController {
	private ProductDetailService productDetailService;
	private ProductService productService;

	public ProductDetailController(ProductDetailService productDetailService, ProductService productService) {
		this.productDetailService = productDetailService;
		this.productService = productService;
	}

	@GetMapping(value = "/index")
	public String productDetails(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) {
		List<ProductDetail> productDetails = productDetailService.getAllProductDetail();
		model.addAttribute("listProductDetails", productDetails);
		model.addAttribute("keyword", keyword);
		return "admin/list/productDetails_list";
	}

	@GetMapping(value = "/create")
	public String formProductDetails(Model model) {
		model.addAttribute("productDetail", new ProductDetail());
		List<Product> products = productService.getAllProduct();
		model.addAttribute("listProducts", products);

		return "admin/entry/productDetail_entry";
	}

	@GetMapping(value = "/delete/{id}")
	public String deleteProductDetail(@PathVariable(value = "id") Integer id, String keyword) {
		productDetailService.removeProductDetail(id);
		return "redirect:/productDetail/index?keyword=" + keyword;
	}

	@GetMapping(value = "/update/{id}")
	public String updateProductDetail(@PathVariable(value = "id") Integer id, Model model) {
		ProductDetail productDetail = productDetailService.loadProductDetailById(id);
		model.addAttribute("productDetail", productDetail);
		List<Product> products = productService.getAllProduct();
		model.addAttribute("listProducts", products);

		return "admin/edit/productDetail_edit";
	}

	@PostMapping(value = "/save")
	public String save(ProductDetail productDetail) {
		productDetailService.createOrUpdateProductDetail(productDetail);
		return "redirect:/productDetail/index";
	}

}
