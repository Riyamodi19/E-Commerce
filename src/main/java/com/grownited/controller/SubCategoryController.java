package com.grownited.controller;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.CategoryEntity;
import com.grownited.entity.SubCategoryEntity;
import com.grownited.repository.CategoryRepository;
import com.grownited.repository.SubCategoryRepository;

@Controller
public class SubCategoryController {
	@Autowired
	SubCategoryRepository repoSubCategory;
	
	@Autowired
	CategoryRepository repoCategory;
	
   @GetMapping("newsubcategory")
   public String newSubCategory(Model model) {
	   List<CategoryEntity> allCategory = repoCategory.findAll();
		model.addAttribute("allCategory",allCategory);
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
	   List<Object[]> listsubCategory = repoSubCategory.getAll();// select * from members; //500 -> MemberEntity
   	
   	//how to send data from controller to jsp 
   	//Model 
	   model.addAttribute("allsubCategory",listsubCategory);
   					//dataName , dataValue 
   	
   	return "ListSubCategory";
   }
 //view subcategory

 	@GetMapping("viewsubcategory")
 	public String viewSubCategory(Integer subCategoryId, Model model) {
 		// ?
 		System.out.println("id ===> " + subCategoryId);
 		Optional<SubCategoryEntity> op = repoSubCategory.findById(subCategoryId);
 		if (op.isEmpty()) {
 			// not found
 		} else {
 			// data found
 	        SubCategoryEntity subCategory = op.get();
 			// send data to jsp ->
 			model.addAttribute("subCategory", subCategory);

 		}

 		return "ViewSubCategory";
 	}
 	//delete product
 	@GetMapping("deletesubcategory")
 	public String deleteSubCategory(Integer subCategoryId) {
 		repoSubCategory.deleteById(subCategoryId);//delete from members where memberID = :memberId
 		return "redirect:/listsubcategory";
 	}
}
