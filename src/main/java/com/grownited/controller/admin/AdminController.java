package com.grownited.controller.admin;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.grownited.repository.OrdersRepository;
import com.grownited.repository.ProductRepository;
import com.grownited.repository.UserRepository;

@Controller
public class AdminController {
	@Autowired
	UserRepository repoUser;
	
	@Autowired
	OrdersRepository repoOrders;
	
	@Autowired
	ProductRepository repoProduct;
	
	@GetMapping("admindashboard")
	public String adminDashboard(Model model) {
		//total users
		//total this month users
		//this month total orders
		//total products
		
		//select count(*) from users; 
				Long totalUsers = repoUser.count();//total of users table 
				Long totalProduct = repoProduct.count();//total of product table 
				Long totalOrders = repoOrders.count();//total of order table 
				
				//select * from users where role = 'USER'; 
				Integer totalBuyer =repoUser.findByRole("BUYER").size();
				Integer totalAdmin =repoUser.findByRole("ADMIN").size();
				
				//Long totalOrders=repoOrders.count();
				LocalDate today=LocalDate.now();
				int month=today.getMonthValue();
				Integer thisMonthBuyerCount = repoUser.countThisMonthBuyer(month);
				Integer thisMonthOrdersCount = repoOrders.countThisMonthOrders(month);
				
				Integer monthWiseBuyers [] = new Integer[12];
				
				for(int i=1;i<=12;i++) {
					monthWiseBuyers [i-1] = repoUser.countMonthwiseBuyers(i);
				}
				
				model.addAttribute("totalBuyer",totalBuyer);
				//model.addAttribute("totalOrders",totalOrders);
				model.addAttribute("thisMonthBuyerCount",thisMonthBuyerCount);
				model.addAttribute("thisMonthOrdersCount",thisMonthOrdersCount);
				model.addAttribute("totalProduct", totalProduct);
				
				model.addAttribute("monthWiseBuyers",monthWiseBuyers);
				System.out.println("monthwisebuyer"+monthWiseBuyers);
		         
		return "AdminDashboard";
	}
	@GetMapping("userprofile")
	public String userprofile() {
		return "UserProfile";
	}
	
}
