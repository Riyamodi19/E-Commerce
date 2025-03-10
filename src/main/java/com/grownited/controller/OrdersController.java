package com.grownited.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.grownited.entity.OrdersEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.OrdersRepository;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrdersController {
	@Autowired
   OrdersRepository repoOrders;
	
	@Autowired
	UserRepository repoUser;
	
	@GetMapping("neworders")
	public String newOrders(Model model) {
    List<UserEntity> allUser = repoUser.findAll();
	 model.addAttribute("allUser",allUser);
		return "NewOrders";
	}
	@PostMapping("saveorders")
	public String saveOrders(OrdersEntity ordersEntity, HttpSession session) {
		System.out.println(ordersEntity.getTotalAmount());
		 UserEntity user = (UserEntity) session.getAttribute("user");
			Integer userId = user.getUserId(); 
		    ordersEntity.setUserId(userId);
		    ordersEntity.setCreatedAt(new Date());
		repoOrders.save(ordersEntity);
		return "redirect:/listorders";
	}
	//list orders
	@GetMapping("listorders")
	  public String listOrders(Model model) {
	  	List<Object[]> listOrders = repoOrders.getAll();// select * from members; //500 -> MemberEntity
	  	
	  	//how to send data from controller to jsp 
	  	//Model 
	  	model.addAttribute("allOrders", listOrders);
	  					//dataName , dataValue 
	  	
	  	return "ListOrders";
	  }
	//view orders

	@GetMapping("vieworders")
	public String viewOrders(Integer orderId, Model model) {
		// ?
		System.out.println("id ===> " + orderId);
		Optional<OrdersEntity> op = repoOrders.findById(orderId);
		if (op.isEmpty()) {
			// not found
		} else {
			// data found
	        OrdersEntity orders = op.get();
			// send data to jsp ->
			model.addAttribute("orders", orders);

		}

		return "ViewOrders";
	}
	//delete orders
	@GetMapping("deleteorders")
	public String deleteOrders(Integer orderId) {
		repoOrders.deleteById(orderId);//delete from members where memberID = :memberId
		return "redirect:/listorders";
	}
}
