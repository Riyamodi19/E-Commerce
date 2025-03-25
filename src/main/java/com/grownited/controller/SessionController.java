package com.grownited.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.grownited.Service.MailService;
import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController{
	@Autowired
	MailService serviceMail;
	
    @Autowired //for creating object
    UserRepository repoUser;
    
    @Autowired
	PasswordEncoder encoder;

    @Autowired
	Cloudinary cloudinary;

	@GetMapping(value = {"/","signup"})//url
	public String signup() {
		return "Signup";//jsp
	}
	
    @GetMapping("login")//url
    public String Login() {
    	return "Login";//jsp name
    }
   
    @PostMapping("saveuser")
    public String saveUser(UserEntity userEntity,MultipartFile profilePic) {
    	
    	System.out.println(profilePic.getOriginalFilename());// file name
		// cloud->
		
//		if(profilePic.getOriginalFilename().endsWith(".jpg") || || || ) {
//			
//		}else {
//			//
//			//model 
//			return "Signup";
//		}
		try {
			Map result = cloudinary.uploader().upload(profilePic.getBytes(), ObjectUtils.emptyMap());
			//System.out.println(result);
			//System.out.println(result.get("url"));
			userEntity.setProfilePicPath(result.get("url").toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	String encPassword = encoder.encode(userEntity.getPassword());
		String encconfirmPassword = encoder.encode(userEntity.getConfirmPassword());
		userEntity.setPassword(encPassword);
		userEntity.setConfirmPassword(encconfirmPassword);
		 //memory 
		//bcrypt singleton -> single object -> autowired
		
    	userEntity.setRole("BUYER");
    	userEntity.setCreatedAt(new Date());
    	
    
    	//read
    	System.out.println(userEntity.getFirstName());
    	System.out.println(userEntity.getLastName());
    	System.out.println(userEntity.getEmail());
    	System.out.println(userEntity.getPassword());
    	System.out.println(userEntity.getConfirmPassword());
    	System.out.println(userEntity.getGender());
    	System.out.println(userEntity.getContactNum());
    	repoUser.save(userEntity);
    	// send mail
     serviceMail.sendWelcomeMail(userEntity.getEmail(), userEntity.getFirstName());
    	 return "Login";
    }
    
    
    //open forgetpassword.jsp
    @GetMapping("forgetpassword")
    public String forgetPassword() {
    	return "ForgetPassword";
    }
    //submit on forgetpassword
    
    @PostMapping("sendOtp")
    public String sendOtp(String email, Model model) {
    	// email valid
    			Optional<UserEntity> op = repoUser.findByEmail(email);
    			if (op.isEmpty()) {
    				// email invalid
    				model.addAttribute("error", "Email not found");
    				return "ForgetPassword";
    			} else {
    				// email valid
    				// send mail otp
    				// opt generate
    				// send mail otp
    				String otp = "";
    				otp = (int) (Math.random() * 1000000) + "";// 0.25875621458541

    				UserEntity user = op.get();
    				user.setOtp(otp);
    				repoUser.save(user);// update otp for user
    				serviceMail.sendOtpForForgetPassword(email, user.getFirstName(), otp);
    	return "ChangePassword";
    }
    			
    }
    //password update and go to login
    @PostMapping("updatepassword")
    public String updatePassword(String email, String password, String otp, Model model) {
    	Optional<UserEntity> op = repoUser.findByEmail(email);
 		if (op.isEmpty()) {
 			model.addAttribute("error", "Invalid Data");
 			return "ChangePassword";
 		} else {
 			UserEntity user = op.get();
 			if (user.getOtp().equals(otp)) {
 				String encPwd = encoder.encode(password);
 				user.setPassword(encPwd);
 				user.setOtp("");
 				repoUser.save(user);// update
 			} else {

 				model.addAttribute("error", "Invalid Data");
 				return "ChangePassword";
 			}
 		}
 		model.addAttribute("msg","Password updated");
 		return "Login";
    }
    @PostMapping("authenticate")
    public String authenthicate(String email, String password,Model model,HttpSession session) { //sakira@yopmail.com
    	System.out.println(email);
		System.out.println(password);

		// users -> email,password
		Optional<UserEntity> op = repoUser.findByEmail(email);
		// select * from users where email = :email and password = :password
		if (op.isPresent()) {
			// true
			// email
			UserEntity dbUser = op.get();
			
			boolean ans = encoder.matches(password, dbUser.getPassword());
			
			if (ans == true) {
				session.setAttribute("user", dbUser); // session -> user set
				if (dbUser.getRole().equals("ADMIN")) {

					return "redirect:/admindashboard";
				} else if (dbUser.getRole().equals("BUYER")) {

					return "redirect:/home";
				} else {
					model.addAttribute("error", "Please contact Admin with Error Code #0991");
					return "Login";
				}

			}
		}
		model.addAttribute("error","Invalid Credentials");
		return "Login";
	}
    //list user
    @GetMapping("listuser")
	public String listuser(Model model) {
    List<UserEntity> userList =repoUser.findAll();
      model.addAttribute("userList", userList);
		return "ListUser";
	}
    //view user
    @GetMapping("viewuser")
	public String viewuser(Integer userId, Model model) {
		// ?
		System.out.println("id ===> " + userId);
		Optional<UserEntity> op = repoUser.findById(userId);
		if (op.isEmpty()) {
			// not found
		} else {
			// data found
			UserEntity user = op.get();
			// send data to jsp ->
			model.addAttribute("user", user);

		}

		return "ViewUser";
	}
    //delete user
    @GetMapping("deleteuser")
	public String deleteuser(Integer userId) {
		repoUser.deleteById(userId);//delete from members where memberID = :memberId
		return "redirect:/listuser";
	}
  //edit user 

    @GetMapping("edituser")
    public String editUser(Integer userId,Model model) {
    	Optional<UserEntity> op = repoUser.findById(userId);
    	if (op.isEmpty()) {
    		return "redirect:/listuser";
    	} else {
    		model.addAttribute("users",op.get());
    		return "EditUser";

    	}
    }
    //save -> entity -> no id present -> insert 
    //save -> entity -> id present -> not present in db -> insert 
    //save -> entity -> id present -> present in db -> update  

    //update city

    @PostMapping("updateuser")
    public String updateUser(UserEntity userEntity) {//pcode vhreg type vid 
    	
    	System.out.println(userEntity.getUserId());//id? db? 

    	Optional<UserEntity> op = repoUser.findById(userEntity.getUserId());
    	
    	if(op.isPresent())
    	{
    		UserEntity dbUser = op.get(); //pcode vhreg type id userId 
    		dbUser.setFirstName(userEntity.getFirstName());//code 
    		dbUser.setLastName(userEntity.getLastName());//code 
    		dbUser.setEmail(userEntity.getEmail());//code 
    		dbUser.setPassword(userEntity.getPassword());//code 
    		dbUser.setConfirmPassword(userEntity.getConfirmPassword());//code 
    		dbUser.setGender(userEntity.getGender());//code 
    		dbUser.setContactNum(userEntity.getContactNum());//code 
    		repoUser.save(dbUser);
    	}
    	return "redirect:/listuser";
    }

    
     @GetMapping("logout")
	 public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";// login url
	}

}
