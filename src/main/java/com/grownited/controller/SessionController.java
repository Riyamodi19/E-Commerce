package com.grownited.controller;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.Service.MailService;
import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;

@Controller
public class SessionController{
	@Autowired
	MailService serviceMail;
	
    @Autowired //for creating object
    UserRepository repoUser;
    
    @Autowired
	PasswordEncoder encoder;

    
	@GetMapping(value = {"/","signup"})//url
	public String Signup() {
		return "Signup";//jsp
	}
	
    @GetMapping("login")//url
    public String Login() {
    	return "Login";//jsp name
    }
   
    @PostMapping("saveuser")
    public String saveUser(UserEntity userEntity) {
    	String encPassword = encoder.encode(userEntity.getPassword());
		String encconfirmPassword = encoder.encode(userEntity.getConfirmPassword());
		userEntity.setPassword(encPassword);
		userEntity.setConfirmPassword(encconfirmPassword);
		 //memory 
		//bcrypt singleton -> single object -> autowired
		
    	userEntity.setRole("USER");
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
    
    @PostMapping("home")
    public String home(UserEntity userEntity) {
    	   return "Home";
    }
    //open forgetpassword.jsp
    @GetMapping("forgetpassword")
    public String forgetPassword() {
    	return "ForgetPassword";
    }
    //submit on forgetpassword
    @PostMapping("sendOtp")
    public String sendOtp() {
    	return "ChangePassword";
    }
    //password update and go to login
    @PostMapping("updatePassword")
    public String updatePassword() {
    	return "Login";
    }
}
