package com.springboot.jewellerysystem.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.jewellerysystem.entity.Category;
import com.springboot.jewellerysystem.entity.MainCategory;
import com.springboot.jewellerysystem.service.CategoryService;
import com.springboot.jewellerysystem.service.MainCategoryService;
import com.springboot.jewellerysystem.util.FileUploadUtil;

@Controller
@RequestMapping(value = "admin/category")
public class CategoryController {
	private CategoryService categoryService;
	private MainCategoryService mainCategoryService;

	public CategoryController(CategoryService categoryService, MainCategoryService mainCategoryService) {
		this.categoryService = categoryService;
		this.mainCategoryService = mainCategoryService;
	}

	@GetMapping(value = "/index")
	public String categories(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) {
		List<Category> categories = categoryService.getAllCategory();
		model.addAttribute("listCategories", categories);
		model.addAttribute("keyword", keyword);
		return "admin/list/categories_list";
	}

	@GetMapping(value = "/create")
	public String formCategories(Model model) {
		model.addAttribute("category", new Category());
		List<MainCategory> mainCategories = mainCategoryService.getAllMainCategory();
		model.addAttribute("listMainCategories", mainCategories);

		return "admin/entry/category_entry";
	}

	@GetMapping(value = "/delete/{id}")
	public String deleteCategory(@PathVariable(value = "id") Integer id, String keyword) {
		categoryService.removeCategory(id);
		return "redirect:/admin/category/index?keyword=" + keyword;
	}

	@GetMapping(value = "/update/{id}")
	public String updateCategory(@PathVariable(value = "id") Integer id, Model model) {
		Category category = categoryService.loadCategoryById(id);
		
		model.addAttribute("category", category);
		List<MainCategory> mainCategories = mainCategoryService.getAllMainCategory();
		model.addAttribute("listMainCategories", mainCategories);

		return "admin/edit/category_edit";
	}

	@PostMapping(value = "/save")
	public String save(Category category, @RequestParam("file") MultipartFile file) throws IOException {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.length() > 3) {
		category.setImage(fileName);
		String uploadDir = "assets1/images/category";
		FileUploadUtil.saveFile(uploadDir, fileName, file);
		}
		
		categoryService.createOrUpdateCategory(category);
		return "redirect:/admin/category/index";
	}

}
