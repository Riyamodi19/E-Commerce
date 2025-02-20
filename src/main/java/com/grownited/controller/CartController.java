package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.CartEntity;
import com.grownited.repository.CartRepository;

@Controller
public class CartController {
	@Autowired
 CartRepository repoCart;
	
 @GetMapping("newcart")
 public String newCart() {
	return "NewCart";
	}
@PostMapping("savecart")
public String saveCart(CartEntity cartEntity) {
	System.out.println(cartEntity.getQuantity());
	repoCart.save(cartEntity);
	return "NewCart";
}
}
