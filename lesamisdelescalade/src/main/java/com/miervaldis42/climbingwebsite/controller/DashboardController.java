package com.miervaldis42.climbingwebsite.controller;

// Imports
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	String profilePath = "profile/profile-page";


	@GetMapping("users")
	public String showUsersTab(Model sectionModel, Model dashModel) {
		sectionModel.addAttribute("section", "dashboard");
		dashModel.addAttribute("dashSection", "users");

		return profilePath;
	}
	
	@GetMapping("sites")
	public String showSitesTab(Model sectionModel, Model dashModel) {
		sectionModel.addAttribute("section", "dashboard");
		dashModel.addAttribute("dashSection", "sites");

		return profilePath;
	}
	
	@GetMapping("topos")
	public String showToposTab(Model sectionModel, Model dashModel) {
		sectionModel.addAttribute("section", "dashboard");
		dashModel.addAttribute("dashSection", "topos");

		return profilePath;
	}

}