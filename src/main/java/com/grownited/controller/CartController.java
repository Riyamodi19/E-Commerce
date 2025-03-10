package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.grownited.entity.CartEntity;
import com.grownited.entity.ProductEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.CartRepository;
import com.grownited.repository.ProductRepository;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
	@Autowired
    CartRepository repoCart;
	
	 @Autowired
 	 ProductRepository repoProduct;
     
     @Autowired
 	 UserRepository repoUser;
	
 @GetMapping("newcart")
 public String newCart(Model model) {
	 List<ProductEntity> allProduct = repoProduct.findAll();
 	 model.addAttribute("allProduct",allProduct);
 	 
 	 List<UserEntity> allUser = repoUser.findAll();
	 model.addAttribute("allUser",allUser);
	return "NewCart";
	}
@PostMapping("savecart")
public String saveCart(CartEntity cartEntity, HttpSession session) {
	System.out.println(cartEntity.getQuantity());
	UserEntity user = (UserEntity) session.getAttribute("user");
	Integer userId = user.getUserId(); 
    cartEntity.setUserId(userId);
	repoCart.save(cartEntity);
	return "redirect:/listcart";
}
//list cart
@GetMapping("listcart")
public String listCart(Model model) {
	List<Object[]> listCart = repoCart.getAll();// select * from members; //500 -> MemberEntity
	
	//how to send data from controller to jsp 
	//Model 
	model.addAttribute("allCart", listCart);
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

	return "ViewCart";
}
//deletecart
@GetMapping("deletecart")
public String deleteArea(Integer cartId) {
	repoCart.deleteById(cartId);//delete from members where memberID = :memberId
	return "redirect:/listcart";
}

}
