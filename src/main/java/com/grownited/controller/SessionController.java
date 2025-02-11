package com.grownited.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SessionController {
	@GetMapping(value = {"/","signup"})//url
	public String Signup() {
		return "Signup";
	}
	
    @GetMapping("login")//url
    public String Login() {
    	return "Login";//jsp name
    }
    @PostMapping("saveuser")
    public String saveUser() {
    	   return "Login";//jsp
    }
    @PostMapping("user")
    public String user() {
    	   return "Signup";
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
