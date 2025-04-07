package com.grownited.controller.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.grownited.entity.CityEntity;
import com.grownited.entity.SubCategoryEntity;
import com.grownited.repository.CityRepository;
import com.grownited.repository.SubCategoryRepository;

@RestController
public class AjaxController {

	@Autowired
	SubCategoryRepository repoSubCategory; 
	
	@Autowired
	CityRepository repoCity; 
	
	
	@GetMapping("/getallsubcategorybycategoryid/{categoryId}")
	public List<SubCategoryEntity> getAllSubCateByCatId(@PathVariable Integer categoryId) {
		System.out.println(categoryId);
		
		List<SubCategoryEntity> allSubCategory  =  repoSubCategory.findByCategoryId(categoryId);
			
		
		return allSubCategory;
	}
	
	@GetMapping("/getallcitybystateid/{stateId}")
	public List<CityEntity> getAllCityByStateId(@PathVariable Integer stateId) {
		System.out.println(stateId);
		
		List<CityEntity> allCity  =  repoCity.findByStateId(stateId);
			
		
		return allCity;
	}
	
	
}


