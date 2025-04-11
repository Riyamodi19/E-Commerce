package com.grownited.controller;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.grownited.entity.OrderDetailEntity;
import com.grownited.entity.OrdersEntity;
import com.grownited.entity.ProductEntity;
import com.grownited.repository.OrderDetailRepository;
import com.grownited.repository.OrdersRepository;
import com.grownited.repository.ProductRepository;

@Controller
public class OrderDetailController {
	
	@Autowired
	OrderDetailRepository repoOrderDetail;
	
	@Autowired
	ProductRepository repoProduct;
	
	@Autowired
	OrdersRepository repoOrders;
	
	
  @GetMapping("neworderdetail")
  public String newOrderDetail(Model model) {
	  List<ProductEntity> allProduct = repoProduct.findAll();
		model.addAttribute("allProduct",allProduct);
		List<OrdersEntity> allOrders = repoOrders.findAll();
		model.addAttribute("allOrders",allOrders);
	  return "NewOrderDetail";
  }
  @PostMapping("saveorderdetail")
  public String saveOrderDetail(OrderDetailEntity orderDetailEntity) {
	  System.out.println(orderDetailEntity.getQuantity());
	  System.out.println(orderDetailEntity.getPrice());
	  System.out.println(orderDetailEntity.getStatus());
	  repoOrderDetail.save(orderDetailEntity);
	  return "redirect:/listorderdetail";
  }
  //list oder detail
  @GetMapping("listorderdetail")
  public String listOrderDetail(Model model) {
  	List<Object[]> listOrderDetail = repoOrderDetail.getAll();// select * from members; //500 -> MemberEntity
  	
  	//how to send data from controller to jsp 
  	//Model 
  	model.addAttribute("allOrderDetail",listOrderDetail);
  					//dataName , dataValue 
  	
  	return "ListOrderDetail";
  }
//vieworderdetail

@GetMapping("vieworderdetail")
public String viewOrderDetail(Integer orderDetailId, Model model) {
	// ?
//	System.out.println("id ===> " + orderDetailId);
//	Optional<OrderDetailEntity> op = repoOrderDetail.findById(orderDetailId);
//	if (op.isEmpty()) {
//		// not found
//	} else {
//		// data found
//        OrderDetailEntity orderDetail = op.get();
//		// send data to jsp ->
//		model.addAttribute("orderDetail", orderDetail);
//
//	}
	List<Object[]> op = repoOrderDetail.getByOrderDetailId(orderDetailId);
	model.addAttribute("orderDetail", op);
	return "ViewOrderDetail";
}
//delete order detail
@GetMapping("deleteorderdetail")
public String deleteOrderDetail(Integer orderDetailId) {
	repoOrderDetail.deleteById(orderDetailId);//delete from members where memberID = :memberId
	return "redirect:/listorderdetail";
}
//edit oderdetail

@GetMapping("editorderdetail")
public String editOrderDetail(Integer orderDetailId,Model model) {
	Optional<OrderDetailEntity> op = repoOrderDetail.findById(orderDetailId);
	if (!op.isPresent()) {
		return "redirect:/listorderdetail";
	} else {
		model.addAttribute("orderDetail",op.get());
		return "EditOrderDetail";

	}
}
//save -> entity -> no id present -> insert 
//save -> entity -> id present -> not present in db -> insert 
//save -> entity -> id present -> present in db -> update  

//update city

@PostMapping("updateorderdetail")
public String updateOrderDetail(OrderDetailEntity orderDetailEntity) {//pcode vhreg type vid 
	
	System.out.println(orderDetailEntity.getOrderDetailId());//id? db? 

	Optional<OrderDetailEntity> op = repoOrderDetail.findById(orderDetailEntity.getOrderDetailId());
	
	if(op.isPresent())
	{
		OrderDetailEntity dbOrderDetail = op.get(); //pcode vhreg type id userId 
		dbOrderDetail.setQuantity(orderDetailEntity.getQuantity());//code 
		dbOrderDetail.setPrice(orderDetailEntity.getPrice());//code 
		repoOrderDetail.save(dbOrderDetail);
	}
	return "redirect:/listorderdetail";
}



}
