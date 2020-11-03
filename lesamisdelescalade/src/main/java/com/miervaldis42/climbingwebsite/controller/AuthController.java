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

import com.miervaldis42.climbingwebsite.helper.ErrorHandler;


@Controller
@RequestMapping("/auth")
public class AuthController {
	String authDir = "auth/";
	
	@Autowired
	private UserService userService;
	
	// Error variables
	ErrorHandler errorDetector = new ErrorHandler();
	String errorCode = ""; 
	
	
	
	/*
	 * Login page
	 */
	@GetMapping("login")
	public String showLoginPage(Model toast) {
		// Toast to display
		if(errorCode == "201 - User created") {
			String message = errorDetector.displayErrorMessage(errorCode);
			toast.addAttribute("success", message);
		}
		errorCode = "";

		return authDir + "login-page";
	}
	
	
	
	/* 
	 * User inscription
	 */
	@GetMapping("userInscription")
	public String showUserInscriptionPage(Model userModel, Model toast) {
		User newUser = new User();
		userModel.addAttribute("user", newUser);

		// Toast to display
		if(errorCode != "201 - User created") {
			String message = errorDetector.displayErrorMessage(errorCode);
			toast.addAttribute("error", message);
		}
		
		return authDir + "userInscription-page";
	}
	
	@PostMapping("saveUser")
	public String saveUser(@ModelAttribute("user") User newUser) {
		String redirection = "";
		
		if(newUser.getLastname().isEmpty() || newUser.getFirstname().isEmpty() || newUser.getEmail().isEmpty() || newUser.getPassword().isEmpty()) {
			errorCode = "400 - Empty input";
			redirection = "redirect:/auth/userInscription";
			
		} else if(!errorDetector.checkEmail(newUser.getEmail())) {
			errorCode = "400 - Invalid email";
			redirection = "redirect:/auth/userInscription";

		} else {
			Date today = new Date();
			newUser.setCreatedAt(today);
			newUser.setRole(Role.SUBSCRIBER);
			userService.saveUser(newUser);
			
			errorCode = "201 - User created";
			redirection = "redirect:/auth/login";
		}	

		return redirection;
	}

}