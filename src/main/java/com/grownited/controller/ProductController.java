package com.grownited.controller;

import java.util.Date;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.CategoryEntity;
import com.grownited.entity.ProductEntity;
import com.grownited.entity.SubCategoryEntity;
import com.grownited.repository.CategoryRepository;
import com.grownited.repository.ProductRepository;
import com.grownited.repository.SubCategoryRepository;

@Controller
public class ProductController {
	@Autowired
	ProductRepository repoProduct;
		
	@Autowired
	CategoryRepository repoCategory;
	
	@Autowired
	SubCategoryRepository repoSubCategory;
	
	@GetMapping("newproduct")
	public String newProduct(Model model) {
		 List<CategoryEntity> allCategory = repoCategory.findAll();
			model.addAttribute("allCategory",allCategory);
			
		List<SubCategoryEntity> allSubCategory = repoSubCategory.findAll();
			model.addAttribute("allSubCategory",allSubCategory);

		return "NewProduct";
	}
	@PostMapping("saveproduct")
	public String saveProduct(ProductEntity productEntity) {
		System.out.println(productEntity.getProductName());
		System.out.println(productEntity.getBasePrice());
		System.out.println(productEntity.getOfferPrice());
		System.out.println(productEntity.getOfferPercentage());
		System.out.println(productEntity.getProductDetail());
		System.out.println(productEntity.getProductImageURL1());
		System.out.println(productEntity.getProductImageURL2());
		System.out.println(productEntity.getProductImageURL3());
		System.out.println(productEntity.getQuantity());
    	productEntity.setCreatedAt(new Date());
		  repoProduct.save(productEntity);
		  return "redirect:/listproduct";
	}
	//list product
	@GetMapping("listproduct")
	  public String listProduct(Model model) {
	  	List<Object[]> listProduct = repoProduct.getAll();// select * from members; //500 -> MemberEntity
	  	
	  	//how to send data from controller to jsp 
	  	//Model 
	  	model.addAttribute("allProduct", listProduct);
	  					//dataName , dataValue 
	  	
	  	return "ListProduct";
	  }
	//view product

		@GetMapping("viewproduct")
		public String viewProduct(Integer productId, Model model) {
			// ?
//			System.out.println("id ===> " + productId);
//			Optional<ProductEntity> op = repoProduct.findById(productId);
//			if (op.isEmpty()) {
//				// not found
//			} else {
//				// data found
//		        ProductEntity product = op.get();
//				// send data to jsp ->
//				model.addAttribute("product", product);
//
//			}
			List<Object[]> op = repoProduct.getByProductId(productId);
			model.addAttribute("product", op);
			return "ViewProduct";
		}
		//delete product
		@GetMapping("deleteproduct")
		public String deleteProduct(Integer productId) {
			repoProduct.deleteById(productId);//delete from members where memberID = :memberId
			return "redirect:/listproduct";
		}
		
		//edit product

		@GetMapping("editproduct")
		public String editProduct(Integer productId,Model model) {
			Optional<ProductEntity> op = repoProduct.findById(productId);
			if (op.isEmpty()) {
				return "redirect:/listproduct";
			} else {
				model.addAttribute("product",op.get());
				return "EditProduct";

			}
		}
		//save -> entity -> no id present -> insert 
		//save -> entity -> id present -> not present in db -> insert 
		//save -> entity -> id present -> present in db -> update  

		//update product

		@PostMapping("updateproduct")
		public String updateProduct(ProductEntity productEntity) {//pcode vhreg type vid 
			
			System.out.println(productEntity.getProductId());//id? db? 

			Optional<ProductEntity> op = repoProduct.findById(productEntity.getProductId());
			
			if(op.isPresent())
			{
				ProductEntity dbProduct = op.get(); //pcode vhreg type id userId 
				dbProduct.setProductName(productEntity.getProductName());//code 
				dbProduct.setBasePrice(productEntity.getBasePrice());//code 
				dbProduct.setOfferPrice(productEntity.getOfferPrice());//code 
				dbProduct.setOfferePercentage(productEntity.getOfferPercentage());//code 
				dbProduct.setProductDetail(productEntity.getProductDetail());//code 
				dbProduct.setProductImageURL1(productEntity.getProductImageURL1());//code 
				dbProduct.setProductImageURL2(productEntity.getProductImageURL2());//code 
				dbProduct.setProductImageURL3(productEntity.getProductImageURL3());//code 
				dbProduct.setQuantity(productEntity.getQuantity());//code 
				repoProduct.save(dbProduct);
			}
			return "redirect:/listproduct";
		}

		}

