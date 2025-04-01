package com.grownited.controller;

import java.time.LocalDate;
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
		System.out.println(ordersEntity.getStatus());
		 UserEntity user = (UserEntity) session.getAttribute("user");
			Integer userId = user.getUserId(); 
		    ordersEntity.setUserId(userId);
		    LocalDate todaydate=LocalDate.now();
			ordersEntity.setCreatedAt(todaydate);
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
//		System.out.println("id ===> " + orderId);
//		Optional<OrdersEntity> op = repoOrders.findById(orderId);
//		if (op.isEmpty()) {
//			// not found
//		} else {
//			// data found
//	        OrdersEntity orders = op.get();
//			// send data to jsp ->
//			model.addAttribute("orders", orders);
//
//		}
		List<Object[]> op = repoOrders.getByOrderId(orderId);
		model.addAttribute("orders", op);

		return "ViewOrders";
	}
	//delete orders
	@GetMapping("deleteorders")
	public String deleteOrders(Integer orderId) {
		repoOrders.deleteById(orderId);//delete from members where memberID = :memberId
		return "redirect:/listorders";
	}
	//edit orders

	@GetMapping("editorders")
	public String editOrders(Integer orderId,Model model) {
		Optional<OrdersEntity> op = repoOrders.findById(orderId);
		if (op.isEmpty()) {
			return "redirect:/listorders";
		} else {
			model.addAttribute("orders",op.get());
			return "EditOrders";

		}
	}
	//save -> entity -> no id present -> insert 
	//save -> entity -> id present -> not present in db -> insert 
	//save -> entity -> id present -> present in db -> update  

	//update orders

	@PostMapping("updateorders")
	public String updateOrders(OrdersEntity ordersEntity) {//pcode vhreg type vid 
		
		System.out.println(ordersEntity.getOrderId());//id? db? 

		Optional<OrdersEntity> op = repoOrders.findById(ordersEntity.getOrderId());
		
		if(op.isPresent())
		{
			OrdersEntity dbOrders = op.get(); //pcode vhreg type id userId 
			dbOrders.setTotalAmount(ordersEntity.getTotalAmount());//code 
			repoOrders.save(dbOrders);
		}
		return "redirect:/listorders";
	}

	}


