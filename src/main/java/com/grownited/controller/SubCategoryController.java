package com.grownited.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.grownited.entity.SubCategoryEntity;
import com.grownited.repository.SubCategoryRepository;

@Controller
public class SubCategoryController {
	@Autowired
	SubCategoryRepository repoSubCategory;
	
   @GetMapping("newsubcategory")
   public String newSubCategory() {
	   return "NewSubCategory";
   }
   
   @PostMapping("savesubcategory")
   public String saveSubCategory(SubCategoryEntity subCategoryEntity) {
	   System.out.println(subCategoryEntity.getSubCategoryName());
	   repoSubCategory.save(subCategoryEntity);
	   return "redirect:/listsubcategory";
   }
   //list Sub category
   @GetMapping("listsubcategory")
   public String listSubCategory(Model model) {
   	List<SubCategoryEntity> subcategoryList = repoSubCategory.findAll();// select * from members; //500 -> MemberEntity
   	
   	//how to send data from controller to jsp 
   	//Model 
   	model.addAttribute("subcategoryList", subcategoryList);
   					//dataName , dataValue 
   	
   	return "ListSubCategory";
   }
}
