package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.grownited.entity.ProductEntity;
import com.grownited.repository.ProductRepository;

@Controller
public class ProductController {
	@Autowired
	ProductRepository repoProduct;
	
	@GetMapping("newproduct")
	public String newProduct() {
		return "NewProduct";
	}
	@PostMapping("saveproduct")
	public String saveProduct(ProductEntity productEntity) {
		System.out.println(productEntity.getProductName());
		System.out.println(productEntity.getProductDetail());
		System.out.println(productEntity.getProductImageURL1());
		System.out.println(productEntity.getProductImageURL2());
		System.out.println(productEntity.getProductImageURL3());
		repoProduct.save(productEntity);
		return "redirect:/listproduct";
	}
	//list product
	@GetMapping("listproduct")
	  public String listProduct(Model model) {
	  	List<ProductEntity> productList = repoProduct.findAll();// select * from members; //500 -> MemberEntity
	  	
	  	//how to send data from controller to jsp 
	  	//Model 
	  	model.addAttribute("productList", productList);
	  					//dataName , dataValue 
	  	
	  	return "ListProduct";
	  }
	//view product

		@GetMapping("viewproduct")
		public String viewProduct(Integer productId, Model model) {
			// ?
			System.out.println("id ===> " + productId);
			Optional<ProductEntity> op = repoProduct.findById(productId);
			if (op.isEmpty()) {
				// not found
			} else {
				// data found
		        ProductEntity product = op.get();
				// send data to jsp ->
				model.addAttribute("product", product);

			}

			return "ViewProduct";
		}
		//delete product
		@GetMapping("deleteproduct")
		public String deleteProduct(Integer productId) {
			repoProduct.deleteById(productId);//delete from members where memberID = :memberId
			return "redirect:/listproduct";
		}
}
