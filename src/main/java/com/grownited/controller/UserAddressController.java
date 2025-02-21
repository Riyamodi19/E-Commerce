package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.StateEntity;
import com.grownited.entity.UserAddressEntity;
import com.grownited.repository.UserAddressRepository;

@Controller
public class UserAddressController {
	@Autowired
	UserAddressRepository repoUserAddress;
	
	  @GetMapping("newuseraddress")
	   public String newUserAddress() {
		  return "NewUserAddress";
	  }
	  @PostMapping("saveuseraddress")
	  public String saveUserAddress(UserAddressEntity userAddressEntity) {
		  System.out.println(userAddressEntity.getTitle());
		  System.out.println(userAddressEntity.getUnitName());
		  System.out.println(userAddressEntity.getStreet());
		  System.out.println(userAddressEntity.getLandMark());
		  System.out.println(userAddressEntity.getZipCode());
		  repoUserAddress.save(userAddressEntity);
		  return "redirect:/listuseraddress";
	  }
	  //list User Address
	  @GetMapping("listuseraddress")
	  public String listUserAddress(Model model) {
	  	List<UserAddressEntity> userAddressList = repoUserAddress.findAll();// select * from members; //500 -> MemberEntity
	  	
	  	//how to send data from controller to jsp 
	  	//Model 
	  	model.addAttribute("userAddressList", userAddressList);
	  					//dataName , dataValue 
	  	
	  	return "ListUserAddress";
	  }
}
