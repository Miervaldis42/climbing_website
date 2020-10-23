package com.miervaldis42.climbingwebsite.controller;

// Imports
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

import com.miervaldis42.climbingwebsite.entity.Role;
import com.miervaldis42.climbingwebsite.entity.User;
import com.miervaldis42.climbingwebsite.service.UserService;


@Controller
@RequestMapping("/auth")
public class AuthController {
	String authDir = "auth/";
	
	@Autowired
	private UserService userService;
	
	/*
	 * Login page
	 */
	@GetMapping("login")
	public String showLoginPage() {
		return authDir + "login-page";
	}
	
	
	/* 
	 * User inscription
	 */
	@GetMapping("userInscription")
	public String showUserInscriptionPage(Model userModel) {
		User newUser = new User();
		userModel.addAttribute("user", newUser);
		
		return authDir + "userInscription-page";
	}
	
	@PostMapping("saveUser")
	public String saveUser(@ModelAttribute("user") User newUser) {
		String redirection = "";
		
		if(newUser.getLastname().isEmpty() || newUser.getFirstname().isEmpty() || newUser.getEmail().isEmpty() || newUser.getPassword().isEmpty()) {
			redirection = "redirect:/auth/userInscription";
		} else {
			Date today = new Date();
			newUser.setCreatedAt(today);
			newUser.setRole(Role.SUBSCRIBER);
			userService.saveUser(newUser);
			
			redirection = "redirect:/auth/login";
		}	

		return redirection;
	}

}