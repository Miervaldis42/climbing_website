package com.miervaldis42.climbingwebsite.controller;

// Imports
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpSession;
import java.util.Date;

// Entities
import com.miervaldis42.climbingwebsite.enums.Role;
import com.miervaldis42.climbingwebsite.enums.Code;

import com.miervaldis42.climbingwebsite.helper.AuthHelper;
import com.miervaldis42.climbingwebsite.helper.ToastHandler;

import com.miervaldis42.climbingwebsite.entity.User;
import com.miervaldis42.climbingwebsite.service.UserService;




@Controller
@RequestMapping("/auth")
public class AuthController {
	private String authDir = "auth/";
	
	private AuthHelper checkerBot = new AuthHelper();
	private ToastHandler paperBoy = new ToastHandler();
	private Code toastCode = null;
	
	@Autowired
	private UserService userService;
	
	
	
	/*
	 * Login page
	 */
	
	// Show login page
	@GetMapping("login")
	public String showLoginPage(Model credentialsModel, Model toastModel) {
		User unknownUser = new User();
		credentialsModel.addAttribute("credentials", unknownUser);
		
		// Toast
		if(toastCode != null) {
			String toastStatus = paperBoy.throwToastStatus(toastCode);
			String toastMessage = paperBoy.throwToastMessage(toastCode);

			toastModel.addAttribute(toastStatus, toastMessage);
			toastCode = null;
		}

		return authDir + "login-page";
	}
	
	
	// Connexion with provided credentials
	@PostMapping("connexion")
	public String goBackToMainPage(@ModelAttribute("credentials") User unknownUser, HttpSession activeSession) {
		String redirection = "redirect:/auth/login";
		
		// Possible error list
		if(unknownUser.getEmail().isEmpty() || unknownUser.getPassword().isEmpty()) {
			toastCode = Code.FORM_EMPTYINPUT;

			return redirection;
		} else if(!checkerBot.checkEmailFormat(unknownUser.getEmail()) && !unknownUser.getEmail().equals("admin")) {
			toastCode = Code.EMAIL_INVALID;
			
			return redirection;
		}
		
		// If no errors detected, execute transaction
		User user = userService.getUserByCredentials(unknownUser);

		if(user == null) {
			toastCode = Code.USER_NOTFOUND;
			
			return redirection;
		} else {
			activeSession.setAttribute("sessionId", activeSession.getId());
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

		// Toast
		if(toastCode != null && toastCode != Code.USER_CREATED) {
			String toastStatus = paperBoy.throwToastStatus(toastCode);
			String toastMessage = paperBoy.throwToastMessage(toastCode);

			toastModel.addAttribute(toastStatus, toastMessage);
			toastCode = null;
		}
		
		return authDir + "userInscription-page";
	}
	

	// Save the new user
	@PostMapping("saveUser")
	public String saveUser(@ModelAttribute("user") User newUser) {
		String redirection = "redirect:/auth/login";
		
		if(newUser.getLastname().isEmpty() || newUser.getFirstname().isEmpty() || newUser.getEmail().isEmpty() || newUser.getPassword().isEmpty()) {

			toastCode = Code.FORM_EMPTYINPUT;
			return "redirect:/auth/userInscription";
			
		} else if(checkerBot.checkEmailFormat(newUser.getEmail()) == false) {

			toastCode = Code.EMAIL_INVALID;
			return "redirect:/auth/userInscription";

		} else if(userService.checkEmailExists(newUser.getEmail())) {

			toastCode = Code.EMAIL_EXISTING;
			return "redirect:/auth/userInscription";

		} else {

			newUser.setCreatedAt(new Date());
			newUser.setRole(Role.SUBSCRIBER);
			userService.saveUser(newUser);
			
			toastCode = Code.USER_CREATED;
		}

		return redirection;
	}

}