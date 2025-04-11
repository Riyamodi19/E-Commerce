package com.grownited.controller;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.CityEntity;
import com.grownited.entity.StateEntity;
import com.grownited.entity.UserAddressEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.CityRepository;
import com.grownited.repository.StateRepository;
import com.grownited.repository.UserAddressRepository;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserAddressController {
	@Autowired
	UserAddressRepository repoUserAddress;
	
	@Autowired
	UserRepository repoUser;
	
	@Autowired
	StateRepository repoState;
	
	@Autowired
	CityRepository repoCity;
	
	  @GetMapping("newuseraddress")
	   public String newUserAddress(Model model) {
		  List<UserEntity> allUser = repoUser.findAll();
			model.addAttribute("allUser",allUser);
			
			List<StateEntity> allState = repoState.findAll();
			model.addAttribute("allState",allState);
			
			List<CityEntity> allCity = repoCity.findAll();
			model.addAttribute("allCity",allCity);
		  return "NewUserAddress";
	  }
	  @PostMapping("saveuseraddress")
	  public String saveUserAddress(UserAddressEntity userAddressEntity, HttpSession session) {
		  System.out.println(userAddressEntity.getTitle());
		  System.out.println(userAddressEntity.getUnitName());
		  System.out.println(userAddressEntity.getStreet());
		  System.out.println(userAddressEntity.getLandMark());
		  System.out.println(userAddressEntity.getAddressDetail());
		  System.out.println(userAddressEntity.getZipCode());
		  UserEntity user = (UserEntity) session.getAttribute("user");
			Integer userId = user.getUserId(); 
		    userAddressEntity.setUserId(userId);
		  repoUserAddress.save(userAddressEntity);
		  return "redirect:/listuseraddress";
	  }
	  //list User Address
	  @GetMapping("listuseraddress")
	  public String listUserAddress(Model model) {
		  List<Object[]> listUserAddress = repoUserAddress.getAll();// select * from members; //500 -> MemberEntity
	  	
	  	//how to send data from controller to jsp 
	  	//Model 
		  model.addAttribute("allUserAddress",listUserAddress);	  					//dataName , dataValue 
	  	
	  	return "ListUserAddress";
	  }
	//view useraddress

		@GetMapping("viewuseraddress")
		public String viewUserAddress(Integer userAddressId, Model model) {
			// ?
//			System.out.println("id ===> " + userAddressId);
//			Optional<UserAddressEntity> op = repoUserAddress.findById(userAddressId);
//			if (op.isEmpty()) {
//				// not found
//			} else {
//				// data found
//		        UserAddressEntity userAddress = op.get();
//				// send data to jsp ->
//				model.addAttribute("userAddress", userAddress);

//             }
			 List<Object[]> op = repoUserAddress.getByUserAddressId(userAddressId);
			  model.addAttribute("useraddress", op);

			return "ViewUserAddress";
		}
		
		//delete product
		@GetMapping("deleteuseraddress")
		public String deleteUserAddress(Integer userAddressId) {
			repoUserAddress.deleteById(userAddressId);//delete from members where memberID = :memberId
			return "redirect:/listuseraddress";
		}
		//edit user address

		@GetMapping("edituseraddress")
		public String editUserAddress(Integer userAddressId,Model model) {
			Optional<UserAddressEntity> op = repoUserAddress.findById(userAddressId);
			if (!op.isPresent()) {
				return "redirect:/listuseraddress";
				
			} else {
				model.addAttribute("useraddress",op.get());
				return "EditUserAddress";

			}
		}
		//save -> entity -> no id present -> insert 
		//save -> entity -> id present -> not present in db -> insert 
		//save -> entity -> id present -> present in db -> update  

		//update user address

		@PostMapping("updateuseraddress")
		public String updateUserAddress(UserAddressEntity userAddressEntity) {//pcode vhreg type vid 
			
			System.out.println(userAddressEntity.getUserAddressId());//id? db? 

			Optional<UserAddressEntity> op = repoUserAddress.findById(userAddressEntity.getUserAddressId());
			
			if(op.isPresent())
			{
			    UserAddressEntity dbUserAddress = op.get(); //pcode vhreg type id userId 
				dbUserAddress.setTitle(userAddressEntity.getTitle());//code 
				dbUserAddress.setUnitName(userAddressEntity.getUnitName());//code 
				dbUserAddress.setStreet(userAddressEntity.getStreet());//code 
				dbUserAddress.setLandMark(userAddressEntity.getLandMark());//code 
				dbUserAddress.setAddressDetail(userAddressEntity.getAddressDetail());//code 
				dbUserAddress.setZipCode(userAddressEntity.getZipCode());//code 
				//
				repoUserAddress.save(dbUserAddress);
			}
			return "redirect:/listuseraddress";
		}
		}

