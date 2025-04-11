package com.grownited.controller;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.grownited.entity.CategoryEntity;
import com.grownited.repository.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired
	CategoryRepository repoCategory;
	
   @GetMapping("newcategory")
   public String newCategory() {
	   return "NewCategory";
   }
   @PostMapping("savecategory")
   public String saveCategory(CategoryEntity categoryEntity) {
	   System.out.println(categoryEntity.getCategoryName());
	   repoCategory.save(categoryEntity);
	   return "redirect:/listcategory";
   }
   //list category
   @GetMapping("listcategory")
	public String listCategory(Model model) {
		List<CategoryEntity> categoryList = repoCategory.findAll();// select * from members; //500 -> MemberEntity
		
		//how to send data from controller to jsp 
		//Model 
		model.addAttribute("categoryList", categoryList);
						//dataName , dataValue 
		
		return "ListCategory";
	}
 //viewcategory

   @GetMapping("viewcategory")
   public String viewCategory(Integer categoryId, Model model) {
   	// ?
   	System.out.println("id ===> " + categoryId);
   	Optional<CategoryEntity> op = repoCategory.findById(categoryId);
   	if (op.isEmpty()) {
   		// not found
   	} else {
   		// data found
           CategoryEntity category = op.get();
   		// send data to jsp ->
   		model.addAttribute("category", category);

   	}

   	return "ViewCategory";
   }
   //deletecategory
   @GetMapping("deletecategory")
   public String deleteCategory(Integer categoryId) {
   	repoCategory.deleteById(categoryId);//delete from members where memberID = :memberId
   	return "redirect:/listcategory";
   }
 //edit category 

   @GetMapping("editcategory")
   public String editCategory(Integer categoryId,Model model) {
   	Optional<CategoryEntity> op = repoCategory.findById(categoryId);
   	if (!op.isPresent()) {
   		return "redirect:/listcategory";
   	} else {
   		model.addAttribute("category",op.get());
   		return "EditCategory";

   	}
   }
   //save -> entity -> no id present -> insert 
   //save -> entity -> id present -> not present in db -> insert 
   //save -> entity -> id present -> present in db -> update  

   //update city

   @PostMapping("updatecategory")
   public String updateCategory(CategoryEntity categoryEntity) {//pcode vhreg type vid 
   	
   	System.out.println(categoryEntity.getCategoryId());//id? db? 

   	Optional<CategoryEntity> op = repoCategory.findById(categoryEntity.getCategoryId());
   	
   	if(op.isPresent())
   	{
   		CategoryEntity dbCategory = op.get(); //pcode vhreg type id userId 
   		dbCategory.setCategoryName(categoryEntity.getCategoryName());//code 
   		repoCategory.save(dbCategory);
   	}
   	return "redirect:/listcity";
   }

   }



