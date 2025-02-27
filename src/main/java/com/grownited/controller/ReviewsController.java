package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.grownited.entity.ReviewsEntity;
import com.grownited.repository.ReviewsRepository;

@Controller
public class ReviewsController {
	
     @Autowired
     ReviewsRepository repoReviews;
     
     @GetMapping("newreviews")
     public String newReviews() {
    	 return "NewReviews";
     }
     
    @PostMapping("savereviews")
    public String saveReviews(ReviewsEntity reviewsEntity) {
    	System.out.println(reviewsEntity.getReviewText());
    	System.out.println(reviewsEntity.getRating());
    	repoReviews.save(reviewsEntity);
    	return "redirect:/listreviews";
    }
    //list Reviews
    @GetMapping("listreviews")
	  public String listReviews(Model model) {
	  	List<ReviewsEntity> reviewsList = repoReviews.findAll();// select * from members; //500 -> MemberEntity
	  	
	  	//how to send data from controller to jsp 
	  	//Model 
	  	model.addAttribute("reviewsList", reviewsList);
	  					//dataName , dataValue 
	  	
	  	return "ListReviews";
	  }
  //view reviews

  		@GetMapping("viewreviews")
  		public String viewProduct(Integer reviewId, Model model) {
  			// ?
  			System.out.println("id ===> " + reviewId);
  			Optional<ReviewsEntity> op = repoReviews.findById(reviewId);
  			if (op.isEmpty()) {
  				// not found
  			} else {
  				// data found
  		        ReviewsEntity reviews = op.get();
  				// send data to jsp ->
  				model.addAttribute("reviews", reviews);

  			}

  			return "ViewReviews";
  		}
  		//delete product
  		@GetMapping("deletereviews")
  		public String deleteReviews(Integer reviewsId) {
  			repoReviews.deleteById(reviewsId);//delete from members where memberID = :memberId
  			return "redirect:/listreviews";
  		}
}
