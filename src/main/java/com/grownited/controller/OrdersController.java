package com.grownited.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.grownited.entity.OrdersEntity;
import com.grownited.repository.OrdersRepository;

@Controller
public class OrdersController {
	@Autowired
   OrdersRepository repoOrders;
	
	@GetMapping("neworders")
	public String newOrders() {
		return "NewOrders";
	}
	@PostMapping("saveorders")
	public String saveOrders(OrdersEntity ordersEntity) {
		System.out.println(ordersEntity.getTotalAmount());
		repoOrders.save(ordersEntity);
		return "redirect:/listorders";
	}
	//list orders
	@GetMapping("listorders")
	  public String listOrders(Model model) {
	  	List<OrdersEntity> ordersList = repoOrders.findAll();// select * from members; //500 -> MemberEntity
	  	
	  	//how to send data from controller to jsp 
	  	//Model 
	  	model.addAttribute("ordersList", ordersList);
	  					//dataName , dataValue 
	  	
	  	return "ListOrders";
	  }
}
