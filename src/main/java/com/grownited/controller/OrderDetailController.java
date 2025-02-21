package com.grownited.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.grownited.entity.OrderDetailEntity;
import com.grownited.repository.OrderDetailRepository;

@Controller
public class OrderDetailController {
	
	@Autowired
	OrderDetailRepository repoOrderDetail;
	
  @GetMapping("neworderdetail")
  public String newOrderDetail() {
	  return "NewOrderDetail";
  }
  @PostMapping("saveorderdetail")
  public String saveOrderDetail(OrderDetailEntity orderDetailEntity) {
	  System.out.println(orderDetailEntity.getQuantity());
	  System.out.println(orderDetailEntity.getPrice());
	  repoOrderDetail.save(orderDetailEntity);
	  return "redirect:/listorderdetail";
  }
  //list oder detail
  @GetMapping("listorderdetail")
  public String listOrderDetail(Model model) {
  	List<OrderDetailEntity> orderDetailList = repoOrderDetail.findAll();// select * from members; //500 -> MemberEntity
  	
  	//how to send data from controller to jsp 
  	//Model 
  	model.addAttribute("orderDetailList", orderDetailList);
  					//dataName , dataValue 
  	
  	return "ListOrderDetail";
  }
}
