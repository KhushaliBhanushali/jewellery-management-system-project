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

import com.springboot.jewellerysystem.entity.Banner;
import com.springboot.jewellerysystem.entity.BannerImage;
import com.springboot.jewellerysystem.service.BannerImageService;
import com.springboot.jewellerysystem.service.BannerService;
import com.springboot.jewellerysystem.util.FileUploadUtil;



@Controller
@RequestMapping(value = "admin/bannerImage")
public class BannerImageController {
	private BannerImageService bannerImageService;
	private BannerService bannerService;

	public BannerImageController(BannerImageService bannerImageService, BannerService bannerService) {
		this.bannerImageService = bannerImageService;
		this.bannerService = bannerService;
	}

	@GetMapping(value = "/index")
	public String bannerImages(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) {
		List<BannerImage> bannerImages = bannerImageService.getAllBannerImage();
		model.addAttribute("listBannerImages", bannerImages);
		model.addAttribute("keyword", keyword);
		return "admin/list/bannerImages_list";
	}

	@GetMapping(value = "/create")
	public String formBannerImages(Model model) {
		model.addAttribute("bannerImage", new BannerImage());
		List<Banner> banners = bannerService.getAllBanner();
		model.addAttribute("listBanners", banners);

		return "admin/entry/bannerImage_entry";
	}

	@GetMapping(value = "/delete/{id}")
	public String deleteBannerImage(@PathVariable(value = "id") Integer id, String keyword) {
		bannerImageService.removeBannerImage(id);
		return "redirect:/admin/bannerImage/index?keyword=" + keyword;
	}

	@GetMapping(value = "/update/{id}")
	public String updateBannerImage(@PathVariable(value = "id") Integer id, Model model) {
		BannerImage bannerImage = bannerImageService.loadBannerImageById(id);
		
		model.addAttribute("bannerImage", bannerImage);
		List<Banner> banners = bannerService.getAllBanner();
		model.addAttribute("listBanners", banners);

		return "admin/edit/bannerImage_edit";
	}

	@PostMapping(value = "/save")
	public String save(BannerImage bannerImage, @RequestParam("file")MultipartFile file) throws IOException {
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		if(fileName.length() > 3) {
			bannerImage.setBannerImage(fileName);		
			String uploadDir = "assets1/images/bannerImage";
			FileUploadUtil.saveFile(uploadDir, fileName, file);
		}
		
		bannerImageService.createOrUpdateBannerImage(bannerImage);
		return "redirect:/admin/bannerImage/index";
	}

}
