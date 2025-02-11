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
    
    @GetMapping("forgetpassword")
    public String ForgetPassword() {
    	return "ForgetPassword";
    }
}
