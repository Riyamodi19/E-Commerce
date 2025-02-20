package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	   return "NewCategory";
   }
}
