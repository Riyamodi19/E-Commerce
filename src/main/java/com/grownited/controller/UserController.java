package com.grownited.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@GetMapping("home")
	public String home() {
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
