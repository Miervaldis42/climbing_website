package com.miervaldis42.climbingwebsite.controller;

// Imports
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/auth")
public class AuthController {
	String authDir = "auth/";
	
	// Show login page
	@GetMapping("login")
	public String showLoginPage() {
		return authDir + "login-page";
	}
}