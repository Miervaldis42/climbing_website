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
import javax.servlet.http.HttpSession;

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
	
	// Variables for error handling
	ErrorHandler errorDetector = new ErrorHandler();
	String toastCode = ""; 
	
	
	
	/*
	 * Login page
	 */
	
	// Show login page
	@GetMapping("login")
	public String showLoginPage(Model credentialsModel, Model toastModel) {
		User unknownUser = new User();
		credentialsModel.addAttribute("credentials", unknownUser);
		
		// Toast to display
		if(toastCode == "201 - User created") {
			String message = errorDetector.displayToastMessage(toastCode);
			toastModel.addAttribute("success", message);
		} else if(toastCode == "409 - Pre-existing Email") {
			toastCode = "";
		} else {
			String message = errorDetector.displayToastMessage(toastCode);
			toastModel.addAttribute("error", message);
		}
		toastCode = "";

		return authDir + "login-page";
	}
	
	
	// Connexion with provided credentials
	@PostMapping("connexion")
	public String goBackToMainPage(@ModelAttribute("credentials") User unknownUser, HttpSession activeSession) {
		String redirection = "redirect:/auth/login";
		
		// Possible error list
		if(unknownUser.getEmail().isEmpty() || unknownUser.getPassword().isEmpty()) {
			toastCode = "400 - Empty input";
			return redirection;

		} else if(!errorDetector.checkEmail(unknownUser.getEmail()) && !Objects.equals(unknownUser.getEmail(), "admin")) {
			toastCode = "400 - Invalid email";
			return redirection;

		}
		
		// If no errors detected, execute transaction
		User user = userService.getUserByCredentials(unknownUser);

		if(user == null) {
			toastCode = "404 - User Not Found";
			return redirection;
		} else {
			activeSession.setAttribute("id", user.getId());
			activeSession.setAttribute("lastname", user.getLastname());
			activeSession.setAttribute("firstname", user.getFirstname());
			activeSession.setAttribute("email", user.getEmail());
			activeSession.setAttribute("role", user.getRole());
			
			redirection = "redirect:/sites";
		}
		
		return redirection;
	}
	
	
	
	/* 
	 * User inscription
	 */
	
	// Show user inscription page
	@GetMapping("userInscription")
	public String showUserInscriptionPage(Model userModel, Model toastModel) {
		User newUser = new User();
		userModel.addAttribute("user", newUser);

		// Toast to display
		if(toastCode != "201 - User created") {
			String message = errorDetector.displayToastMessage(toastCode);
			toastModel.addAttribute("error", message);
		}
		
		return authDir + "userInscription-page";
	}
	

	// Save the new user
	@PostMapping("saveUser")
	public String saveUser(@ModelAttribute("user") User newUser) {
		String redirection = "redirect:/auth/login";
		
		// Check cases
		if(newUser.getLastname().isEmpty() || newUser.getFirstname().isEmpty() || newUser.getEmail().isEmpty() || newUser.getPassword().isEmpty()) {
			toastCode = "400 - Empty input";
			redirection = "redirect:/auth/userInscription";
			return redirection;
			
		} else if(!errorDetector.checkEmail(newUser.getEmail())) {
			toastCode = "400 - Invalid email";
			redirection = "redirect:/auth/userInscription";
			return redirection;

		} else if(userService.checkEmailExists(newUser.getEmail())) {
			toastCode = "409 - Pre-existing Email";
			redirection = "redirect:/auth/userInscription";
			return redirection;
		} else {
			Date today = new Date();
			newUser.setCreatedAt(today);
			newUser.setRole(Role.SUBSCRIBER);
			userService.saveUser(newUser);
			
			toastCode = "201 - User created";
		}

		return redirection;
	}

}