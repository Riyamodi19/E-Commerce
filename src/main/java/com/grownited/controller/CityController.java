package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.CityEntity;
import com.grownited.repository.CityRepository;

@Controller
public class CityController {
	@Autowired
	CityRepository repoCity;
@GetMapping("city")
public String city() {
	return "City";
}
@PostMapping("savecity")
public String saveCity(CityEntity cityEntity) {
	System.out.println(cityEntity.getCityName());
	repoCity.save(cityEntity);
	return "City";
}
}
