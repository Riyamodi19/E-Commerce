package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ProductEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.CartRepository;
import com.grownited.repository.ProductRepository;
import com.grownited.repository.WishlistRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	ProductRepository repoProduct;
	
	@Autowired
	WishlistRepository wishlistRepository;
	
	@Autowired
 	CartRepository repocart;
	
	@GetMapping("home")
	public String home(Model model,HttpSession session) {

		List<ProductEntity> allProduct = repoProduct.findAll();
		model.addAttribute("allProduct",allProduct); 
		
		UserEntity user  = (UserEntity)session.getAttribute("user");
		Integer totalWishlist  = wishlistRepository.findByUserId(user.getUserId()).size();
		model.addAttribute("totalWishlist",totalWishlist);
		
		Integer totalCart = repocart.findByUserId(user.getUserId()).size();
 		model.addAttribute("totalCart", totalCart);
		
		return "Home";
	}
	@GetMapping("product")
public String product(Integer categoryId,Integer productId, Model model,HttpSession session) {
 		
 		UserEntity user = (UserEntity) session.getAttribute("user");
 	    Integer userId = user.getUserId(); 
 		
 	    List<ProductEntity> allProduct = null;// all state
 	    
 	   if (categoryId == null) {
		  	allProduct = repoProduct.findAll();
		} else {
			allProduct = repoProduct.findByCategoryId(categoryId);// all state
		}
 	   
 		model.addAttribute("allProduct",allProduct);
 		List<Object[]> op = repoProduct.getByProductId(productId);
 		
 		Integer totalWishlist  = wishlistRepository.findByUserId(user.getUserId()).size();
 		model.addAttribute("totalWishlist",totalWishlist);
 		
 		Integer totalCart = repocart.findByUserId(user.getUserId()).size();
 		model.addAttribute("totalCart", totalCart);
 		
 		model.addAttribute("products", op);
 		return "Product";
	}
	
	@GetMapping("productdetail")
	public String productdetail( Model model , Integer productId,HttpSession session) {
 		UserEntity user  = (UserEntity)session.getAttribute("user");
 		
		List<Object[]> products = repoProduct.getByProductId(productId);;
		model.addAttribute("products",products);
		Integer totalWishlist  = wishlistRepository.findByUserId(user.getUserId()).size();
 		model.addAttribute("totalWishlist",totalWishlist);
 		
 		Integer totalCart = repocart.findByUserId(user.getUserId()).size();
 		model.addAttribute("totalCart", totalCart);
 		
		return "ProductDetail";
	}
	@GetMapping("blog")
	public String blog(Model model,HttpSession session) {
 		UserEntity user  = (UserEntity)session.getAttribute("user");
 		Integer totalWishlist  = wishlistRepository.findByUserId(user.getUserId()).size();
 		model.addAttribute("totalWishlist",totalWishlist);
 		
 		Integer totalCart = repocart.findByUserId(user.getUserId()).size();
 		model.addAttribute("totalCart", totalCart);
		return "Blog";
	}
	@GetMapping("about")
	public String about(Model model,HttpSession session) {
 		UserEntity user  = (UserEntity)session.getAttribute("user");
 		Integer totalWishlist  = wishlistRepository.findByUserId(user.getUserId()).size();
 		model.addAttribute("totalWishlist",totalWishlist);
 		
 		Integer totalCart = repocart.findByUserId(user.getUserId()).size();
 		model.addAttribute("totalCart", totalCart);
		return "About";
	}

	@GetMapping("contact")
	public String contact(Model model,HttpSession session) {
 		UserEntity user  = (UserEntity)session.getAttribute("user");
 		Integer totalWishlist  = wishlistRepository.findByUserId(user.getUserId()).size();
 		model.addAttribute("totalWishlist",totalWishlist);
 		
 		Integer totalCart = repocart.findByUserId(user.getUserId()).size();
 		model.addAttribute("totalCart", totalCart);
		return "Contact";
	}
	@PostMapping("savecontact")
	public String saveContact() {
		return "redirect:/home";
	}
	@GetMapping("blogdetail")
	public String blogdetail(Model model,HttpSession session) {
 		UserEntity user  = (UserEntity)session.getAttribute("user");
 		Integer totalWishlist  = wishlistRepository.findByUserId(user.getUserId()).size();
 		model.addAttribute("totalWishlist",totalWishlist);
 		
 		Integer totalCart = repocart.findByUserId(user.getUserId()).size();
 		model.addAttribute("totalCart", totalCart);
		return "BlogDetail";
	}
	
	@GetMapping("wishlist")
	public String wishlist(Integer productId, Model model, HttpSession session) {
	    UserEntity user = (UserEntity) session.getAttribute("user");
	    if (user == null) return "redirect:/login";

	    Integer userId = user.getUserId(); 

	    // Total count values for header
	    model.addAttribute("totalWishlist", wishlistRepository.findByUserId(userId).size());
	    model.addAttribute("totalCart", repocart.findByUserId(userId).size());

	    // Add all products (if needed elsewhere)
	    List<ProductEntity> allProduct = repoProduct.findAll();
	    model.addAttribute("allProduct", allProduct);

	    // ✅ Fetch actual wishlist products
	    List<ProductEntity> wishlistProducts = repoProduct.findWishlistProductsByUserId(userId); // You need this method
	    model.addAttribute("wishlistProducts", wishlistProducts); // <-- Use this in your JSP

	    return "Wishlist";
	}

}
