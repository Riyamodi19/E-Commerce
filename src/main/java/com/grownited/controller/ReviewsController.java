package com.grownited.controller;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.grownited.entity.ProductEntity;
import com.grownited.entity.ReviewsEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ProductRepository;
import com.grownited.repository.ReviewsRepository;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReviewsController {
	
     @Autowired
     ReviewsRepository repoReviews;
     
     @Autowired
 	 ProductRepository repoProduct;
     
     @Autowired
 	 UserRepository repoUser;
     
     @GetMapping("newreviews")
     public String newReviews(Model model) {
     List<ProductEntity> allProduct = repoProduct.findAll();
 	 model.addAttribute("allProduct",allProduct);
 	 
 	 List<UserEntity> allUser = repoUser.findAll();
	 model.addAttribute("allUser",allUser);
    	 return "NewReviews";
     }
     
    @PostMapping("savereviews")
    public String saveReviews(ReviewsEntity reviewsEntity, HttpSession session) {
    	System.out.println(reviewsEntity.getReviewText());
    	System.out.println(reviewsEntity.getRating());
    	UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId(); 
	    reviewsEntity.setUserId(userId);
	    reviewsEntity.setCreatedAt(new Date());
    	repoReviews.save(reviewsEntity);
    	return "redirect:/listreviews";
    }
    //list Reviews
    @GetMapping("listreviews")
	  public String listReviews(Model model) {
	  	List<Object[]> listReviews = repoReviews.getAll();// select * from members; //500 -> MemberEntity
	  	
	  	//how to send data from controller to jsp 
	  	//Model 
	  	model.addAttribute("allReviews", listReviews);
	  					//dataName , dataValue 
	  	
	  	return "ListReviews";
	  }
  //view reviews

  		@GetMapping("viewreviews")
  		public String viewProduct(Integer reviewId, Model model) {
  			// ?
//  			System.out.println("id ===> " + reviewId);
//  			Optional<ReviewsEntity> op = repoReviews.findById(reviewId);
//  			if (op.isEmpty()) {
//  				// not found
//  			} else {
//  				// data found
//  		        ReviewsEntity reviews = op.get();
//  				// send data to jsp ->
//  				model.addAttribute("reviews", reviews);
//
//  			}
  			List<Object[]> op = repoReviews.getByReviewId(reviewId);
  			model.addAttribute("reviews", op);
  			return "ViewReviews";
  		}
  		//delete product
  		@GetMapping("deletereviews")
  		public String deleteReviews(Integer reviewsId) {
  			repoReviews.deleteById(reviewsId);//delete from members where memberID = :memberId
  			return "redirect:/listreviews";
  		}
  	//edit reviews

  		@GetMapping("editreviews")
  		public String editReviews(Integer reviewId,Model model) {
  			Optional<ReviewsEntity> op = repoReviews.findById(reviewId);
  			if (op.isEmpty()) {
  				return "redirect:/listreviews";
  			} else {
  				model.addAttribute("reviews",op.get());
  				return "EditReviews";

  			}
  		}
  		//save -> entity -> no id present -> insert 
  		//save -> entity -> id present -> not present in db -> insert 
  		//save -> entity -> id present -> present in db -> update  

  		//update reviews

  		@PostMapping("updatereviews")
  		public String updateReviews(ReviewsEntity reviewsEntity) {//pcode vhreg type vid 
  			
  			System.out.println(reviewsEntity.getReviewId());//id? db? 

  			Optional<ReviewsEntity> op = repoReviews.findById(reviewsEntity.getReviewId());
  			
  			if(op.isPresent())
  			{
  				ReviewsEntity dbReview = op.get(); //pcode vhreg type id userId 
  				dbReview.setReviewText(reviewsEntity.getReviewText());//code 
  				dbReview.setRating(reviewsEntity.getRating());//code 
  				repoReviews.save(dbReview);
  			}
  			return "redirect:/listcity";
  		}

  		}


