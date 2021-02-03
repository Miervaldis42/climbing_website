package com.miervaldis42.climbingwebsite.controller;

// Imports
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpSession;


@Controller
public class ProfileController {
	String profileDir = "profile/";

	// Display profile page
	@GetMapping("/profile")
	public String showProfilePage() {
		return profileDir + "profile-page";
	}
	
	
	// Log out
	@GetMapping("/logout")
	public String closeCurrentSession(HttpSession activeSession) {
		activeSession.invalidate();

		return "redirect:/sites";
	}

}
