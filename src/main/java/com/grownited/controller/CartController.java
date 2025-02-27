package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	return "redirect:/listcart";
}
//list cart
@GetMapping("listcart")
public String listCart(Model model) {
	List<CartEntity> cartList = repoCart.findAll();// select * from members; //500 -> MemberEntity
	
	//how to send data from controller to jsp 
	//Model 
	model.addAttribute("cartList", cartList);
					//dataName , dataValue 
	
	return "ListCart";
}
//viewcart

@GetMapping("viewcart")
public String viewCart(Integer cartId, Model model) {
	// ?
	System.out.println("id ===> " + cartId);
	Optional<CartEntity> op = repoCart.findById(cartId);
	if (op.isEmpty()) {
		// not found
	} else {
		// data found
        CartEntity cart = op.get();
		// send data to jsp ->
		model.addAttribute("cart", cart);

	}

	return "ViewArea";
}
//deletecart
@GetMapping("deletecart")
public String deleteArea(Integer cartId) {
	repoCart.deleteById(cartId);//delete from members where memberID = :memberId
	return "redirect:/listcart";
}

}
