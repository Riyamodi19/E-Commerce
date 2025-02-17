package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;

@Controller
public class SessionController{
	
    @Autowired //for creating object
    UserRepository repoUser;
    
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
    	userEntity.setRole("USER");
    	//read
    	System.out.println(userEntity.getFirstName());
    	System.out.println(userEntity.getLastName());
    	System.out.println(userEntity.getEmail());
    	System.out.println(userEntity.getPassword());
    	System.out.println(userEntity.getConfirmPassword());
    	System.out.println(userEntity.getGender());
    	System.out.println(userEntity.getContactNum());
    	repoUser.save(userEntity);
    	 return "Login";
    }
    @PostMapping("home")
    public String home(UserEntity userEntity) {
    	System.out.println(userEntity.getEmail());
    	System.out.println(userEntity.getPassword());
    	repoUser.save(userEntity);
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
