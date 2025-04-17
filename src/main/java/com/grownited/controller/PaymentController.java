package com.grownited.controller;

import java.util.List;
import java.lang.Double;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.grownited.Service.MailService;
import com.grownited.Service.PaymentService;
import com.grownited.entity.UserEntity;
import com.grownited.repository.CartRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	MailService serviceMail;


	@GetMapping("checkout")
	public String checkout(Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<Object[]> carts = cartRepository.getAllProductsFromCart(user.getUserId());

		Integer amount = 0;
		for (Object c[] : carts) {
			amount = amount + Integer.parseInt(c[1].toString());
		}

		System.out.println("amount => " + amount);
		model.addAttribute("amount", amount);
		
		return "Checkout";// credit card expDate

	}

	@PostMapping("pay")
	public String pay(@RequestParam("ccNum") String ccNum,@RequestParam("expDate") String expDate,@RequestParam("amount") Double amount,HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");

		// get all items from cart
		List<Object[]> carts = cartRepository.getAllProductsFromCart(user.getUserId());

		/*
		 * Integer amount = 0; for (Object c[] : carts) { amount = amount +
		 * Integer.parseInt(c[1].toString()); }
		 */

		System.out.println("amount => " + amount);
		Integer paymentId = paymentService.chargeCreditCard("6z2uK7Jv7P", "3G9dT8TUy49Urv4m",amount * 1.0, ccNum,
				expDate, user.getEmail(), user.getUserId());
		if (paymentId == -1) {
			return "redirect:/checkout";
		}
//		cartRepo.deleteAll(userId);

		String last4 = ccNum.substring(ccNum.length() - 4);
		serviceMail.sendPaymentStatusMail(user.getEmail(), user.getFirstName(), amount, last4);

		return "redirect:/home";
	}

}