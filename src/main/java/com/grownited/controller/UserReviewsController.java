package com.grownited.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.UserEntity;
import com.grownited.entity.UserReviewsEntity;
import com.grownited.repository.UserReviewsRepository;

import jakarta.servlet.http.HttpSession;


@Controller
public class UserReviewsController {
	
	@Autowired
	UserReviewsRepository repouserreviews;
	
//	@Autowired
//	ProductRepository repoproduct;
	
	@GetMapping("userreviews")
		public String userReviews(Model model) {
		return "UserReviews";
		
	}
//	
	@PostMapping("saveuserreviews")
	public String saveUserReviews(UserReviewsEntity userreviews, HttpSession Session) {
	System.out.println(userreviews.getReviewText());
	System.out.println(userreviews.getRating());
	UserEntity user = (UserEntity) Session.getAttribute("user");
	Integer userId = user.getUserId(); 
	userreviews.setUserId(userId);
	userreviews.setCreatedAt(new Date());
	repouserreviews.save(userreviews);
	return "redirect:/home";
//	
//}
//	//listreviews
//	@GetMapping("listreviews")
//	public String listreviews(Model model) {
//		List<Object[]> listreviews = reporeviews.getAll();
//		
//		//how to send data from controller to jsp 
//		//Model 
//		model.addAttribute("allreviews", listreviews);
//						//dataName , dataValue 
//		
//		return "ListReviews";
//	}
//	@GetMapping("viewreviews")
//	public String viewReviews(Integer reviewId, Model model) {
//		List<Object[]> op = reporeviews.getByReviewId(reviewId);
//		model.addAttribute("reviews", op);
//		return "ViewReviews";
//		// ?
////		System.out.println("id ===> " + reviewId);
////		Optional<ReviewsEntity> op = reporeviews.findById(reviewId);
////		if (op.isEmpty()) {
////			// not found
////		} else {
////			// data found
////			ReviewsEntity reviews = op.get();
////			// send data to jsp ->
////			model.addAttribute("reviews", reviews);
////
////		}
//
//	}
//	
//	@GetMapping("deletereviews")
//	public String deleteReviews(Integer reviewId) {
//		reporeviews.deleteById(reviewId);
//		return "redirect:/listreviews";
//	}	
//	
//	@GetMapping("editreviews")
//	public String editReviews(Integer reviewId,Model model) {
//		Optional<ReviewsEntity> op = reporeviews.findById(reviewId);
//		if (!op.isPresent()) {
//			return "redirect:/listreviews";
//		} else {
//			model.addAttribute("reviews",op.get());
//			return "EditReviews";
//
//		}
//	}
//	//save -> entity -> no id present -> insert 
//	//save -> entity -> id present -> not present in db -> insert 
//	//save -> entity -> id present -> present in db -> update  
//
//	@PostMapping("updatereviews")
//	public String updateReviews(ReviewsEntity reviwEntity) {//pcode vhreg type vid 
//		
//		System.out.println(reviwEntity.getReviewId());//id? db? 
//
//		Optional<ReviewsEntity> op = reporeviews.findById(reviwEntity.getReviewId());
//		
//		if(op.isPresent())
//		{
//			ReviewsEntity dbReviews = op.get(); //pcode vhreg type id userId 
//			dbReviews.setReviewText(reviwEntity.getReviewText());//code 
//			dbReviews.setRating(reviwEntity.getRating());
//			
//			//
//			reporeviews.save(dbReviews);
//		}
//		return "redirect:/listreviews";
//	}

}
}