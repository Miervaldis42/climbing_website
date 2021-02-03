package com.miervaldis42.climbingwebsite.controller;

// Imports
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProfileController {
	String profileDir = "profile/";

	@GetMapping("/profile")
	public String showProfilePage() {
		return profileDir + "profile-page";
	}

}
