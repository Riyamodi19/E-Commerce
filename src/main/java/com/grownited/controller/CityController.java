package com.grownited.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.grownited.entity.CityEntity;
import com.grownited.repository.CityRepository;

@Controller
public class CityController {
	@Autowired
	CityRepository repoCity;
@GetMapping("newcity")
public String newCity() {
	return "NewCity";
}
@PostMapping("savecity")
public String saveCity(CityEntity cityEntity) {
	System.out.println(cityEntity.getCityName());
	repoCity.save(cityEntity);
	return "redirect:/listcity";
}
@GetMapping("listcity")
public String listCity(Model model) {
	List<CityEntity> cityList = repoCity.findAll();// select * from members; //500 -> MemberEntity
	
	//how to send data from controller to jsp 
	//Model 
	model.addAttribute("cityList", cityList);
					//dataName , dataValue 
	
	return "ListCity";
}
}
