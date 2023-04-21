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

import com.springboot.jewellerysystem.entity.Blog;
import com.springboot.jewellerysystem.entity.BlogCategory;
import com.springboot.jewellerysystem.service.BlogCategoryService;
import com.springboot.jewellerysystem.service.BlogService;
import com.springboot.jewellerysystem.util.FileUploadUtil;

@Controller
@RequestMapping(value = "blog")
public class BlogController {
	private BlogService blogService;
	private BlogCategoryService blogCategoryService;

	public BlogController(BlogService blogService, BlogCategoryService blogCategoryService) {
		this.blogService = blogService;
		this.blogCategoryService = blogCategoryService;
	}

	@GetMapping(value = "/index")
	public String blogs(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) {
		List<Blog> blogs = blogService.getAllBlog();
		model.addAttribute("listBlogs", blogs);
		model.addAttribute("keyword", keyword);
		return "admin/list/blogs_list";
	}

	@GetMapping(value = "/create")
	public String formBlogs(Model model) {
		model.addAttribute("blog", new Blog());
		List<BlogCategory> blogCategories = blogCategoryService.getAllBlogCategory();
		model.addAttribute("listBlogCategories", blogCategories);

		return "admin/entry/blog_entry";
	}

	@GetMapping(value = "/delete/{id}")
	public String deleteBlog(@PathVariable(value = "id") Integer id, String keyword) {
		blogService.removeBlog(id);
		return "redirect:/blog/index?keyword=" + keyword;
	}

	@GetMapping(value = "/update/{id}")
	public String updateBlog(@PathVariable(value = "id") Integer id, Model model) {
		Blog blog = blogService.loadBlogById(id);
		model.addAttribute("blog", blog);
		List<BlogCategory> blogCategories = blogCategoryService.getAllBlogCategory();
		model.addAttribute("listBlogCategories", blogCategories);

		return "admin/edit/blog_edit";
	}

	@PostMapping(value = "/save")
	public String save(Blog blog, @RequestParam("file")MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		blog.setImage(fileName);
		String uploadDir = "assets/images/blog";
		FileUploadUtil.saveFile(uploadDir, fileName, file);
		
		blogService.createOrUpdateBlog(blog);
		return "redirect:/blog/index";
	}
	



}
