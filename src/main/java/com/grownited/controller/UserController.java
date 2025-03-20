package com.grownited.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@GetMapping("home")
	public String home() {
		return "Home";
	}
	@GetMapping("contactus")
	public String contactUs() {
		return "ContactUs";
	}
	@GetMapping("aboutus")
	public String aboutUs() {
		return "AboutUs";
	}
	@GetMapping("products")
	public String products() {
		return "Products";
	}
	@GetMapping("singleproduct")
	public String singleProduct() {
		return "SingleProduct";
	}
	@GetMapping("homeheader")
	public String homeHeader() {
		return "HomeHeader";
	}
}
