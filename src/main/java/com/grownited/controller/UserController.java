package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.entity.ProductEntity;
import com.grownited.repository.ProductRepository;

@Controller
public class UserController {
	@Autowired
	ProductRepository repoProduct;
	
	@GetMapping("home")
	public String home(Model model) {
		List<ProductEntity> allProduct = repoProduct.findAll();
		model.addAttribute("allProduct",allProduct); 
		
		
		return "Home";
	}
	@GetMapping("product")
	public String product() {
		return "Product";
	}
	@GetMapping("shopingcart")
	public String shopingCart() {
		return "ShopingCart";
	}
	@GetMapping("productdetail")
	public String productDetail() {
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
	@GetMapping("blogdetail")
	public String blogDetail() {
		return "BlogDetail";
	}
}
