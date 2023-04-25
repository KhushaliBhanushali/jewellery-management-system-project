package com.springboot.jewellerysystem.controller.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.jewellerysystem.entity.Category;
import com.springboot.jewellerysystem.entity.CompanyDetail;
import com.springboot.jewellerysystem.entity.ContactUs;
import com.springboot.jewellerysystem.entity.Faq;
import com.springboot.jewellerysystem.entity.Link;
import com.springboot.jewellerysystem.entity.MainCategory;
import com.springboot.jewellerysystem.entity.OurService;
import com.springboot.jewellerysystem.entity.Product;
import com.springboot.jewellerysystem.service.CategoryService;
import com.springboot.jewellerysystem.service.CompanyDetailService;
import com.springboot.jewellerysystem.service.ContactUsService;
import com.springboot.jewellerysystem.service.FaqService;
import com.springboot.jewellerysystem.service.LinkService;
import com.springboot.jewellerysystem.service.OurServiceService;
import com.springboot.jewellerysystem.service.ProductService;
import com.springboot.jewellerysystem.util.Helper;

@Controller
public class HomeController {
	
	private CategoryService categoryService;
	
	private ProductService productService;
	
	private OurServiceService ourServiceService;
	
	private CompanyDetailService companyDetailService;
	
	private ContactUsService contactUsService;
	
	private LinkService linkService;
	
	private FaqService faqService;

	public HomeController(CategoryService categoryService, ProductService productService,
			OurServiceService ourServiceService, CompanyDetailService companyDetailService,
			ContactUsService contactUsService, LinkService linkService, FaqService faqService) {
		super();
		this.categoryService = categoryService;
		this.productService = productService;
		this.ourServiceService = ourServiceService;
		this.companyDetailService = companyDetailService;
		this.contactUsService = contactUsService;
		this.linkService = linkService;
		this.faqService = faqService;
	}





	
	@GetMapping({"/","/home"})
	public String showHome(Model m) {
		
		Helper helper = new Helper();
		
		
//		List<Category> tabCategory1=helper.getCategoryList(new int[]{1,2,3,4},categoryService);
//		List<Category> tabCategory2=helper.getCategoryList(new int[]{5,11,12,14},categoryService);
//		List<Category> tabCategory3=helper.getCategoryList(new int[]{7,10,6,8},categoryService);
//		
		
	
//	   m.addAttribute("tabCategory1",tabCategory1);
//	   m.addAttribute("tabCategory2",tabCategory2);
//	   m.addAttribute("tabCategory3",tabCategory3);
//		
//	
	   List<Category> listCategory = categoryService.getAllCategoryByMainCategory(new MainCategory(1));
		m.addAttribute("listCategory",listCategory);
		
		List<OurService> listOurService = ourServiceService.getAllOurService();
		m.addAttribute("listOurService",listOurService);
		
		List<Category> listCategory2 = categoryService.getAllCategory().subList(0, 10);
		m.addAttribute("listCategory2",listCategory2);
		
		List<Link> listLink = linkService.getAllLink();
		m.addAttribute("listLink" , listLink);
		
		CompanyDetail companyDetail = companyDetailService.getAllCompanyDetail().get(0);
		m.addAttribute("companyDetail", companyDetail);
	
		
		return "user/index";
	}
	
	@GetMapping("/about")
	public String showAbout(Model m) {
		CompanyDetail companyDetail = companyDetailService.getAllCompanyDetail().get(0);
		m.addAttribute("companyDetail", companyDetail);
	
		
		return "user/about-us";
	}
	
	@GetMapping("/contact")
	public String showContact(Model m,ContactUs contactUs) {
		
		CompanyDetail companyDetail = companyDetailService.getAllCompanyDetail().get(0);
		m.addAttribute("companyDetail", companyDetail);
	
		
		return "user/contact";
	}
	
	@PostMapping("/contact/save")
	public String saveContact(ContactUs contactUs) {
		
		contactUsService.createOrUpdateContactUs(contactUs);
		
		
		return "redirect:/home";
	}
	
	@GetMapping("/faq")
	public String showFaq(Model m) {
		
		List<Faq> listFaq = faqService.getAllFaq();
		m.addAttribute("listFaq", listFaq);
		CompanyDetail companyDetail = companyDetailService.getAllCompanyDetail().get(0);
		m.addAttribute("companyDetail", companyDetail);
		
		return "user/faq";
	}
	
	@GetMapping("/cart")
	public String showCart() {
		return "user/cart";
	}
	
	@GetMapping("/compare")
	public String showCompare() {
		return "user/compare";
	}
	
	@GetMapping("/shop")
	public String showShopPage() {
		return "user/shop";
	}
	
	@GetMapping("/productDetail")
	public String showProductDetail() {
		return "user/single-product";
	}
	
	@GetMapping("/wishlist")
	public String showWishlist() {
		return "user/wishlist";
	}
	
	@GetMapping("/checkout")
	public String showCheckout() {
		return "user/checkout";
	}
	
	@GetMapping("/profile")
	public String showAccount() {
		return "user/my-account";
	}
	
	

}
