package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ProductEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ProductRepository;
import com.grownited.repository.WishlistRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	ProductRepository repoProduct;
	
	@Autowired
	WishlistRepository wishlistRepository;
	
	@GetMapping("home")
	public String home(Model model,HttpSession session) {

		List<ProductEntity> allProduct = repoProduct.findAll();
		model.addAttribute("allProduct",allProduct); 
		
		UserEntity user  = (UserEntity)session.getAttribute("user");
		Integer totalWishlist  = wishlistRepository.findByUserId(user.getUserId()).size();
		model.addAttribute("totalWishlist",totalWishlist);
		
		return "Home";
	}
	@GetMapping("product")
	public String product() {
		return "Product";
	}
	
	@GetMapping("productdetail")
	public String productDetail(Model model, Integer productId) {
		List<Object[]> products = repoProduct.getByProductId(productId);;
		model.addAttribute("products",products);
		return "ProductDetail";
	}
	@GetMapping("blog")
	public String blog() {
		return "Blog";
	}
	@GetMapping("about")
	public String about() {
		return "About";
	}

	@GetMapping("contact")
	public String contact() {
		return "Contact";
	}
	@PostMapping("savecontact")
	public String saveContact() {
		return "redirect:/home";
	}
	@GetMapping("blogdetail")
	public String blogDetail() {
		return "BlogDetail";
	}
}
