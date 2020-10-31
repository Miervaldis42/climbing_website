package com.miervaldis42.climbingwebsite.controller;

// Imports
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
	
	@RequestMapping("/sites")
	public String showTestPage(HttpSession activeSession, Model session) {	
		
		// Check a user is currently in session
		if(activeSession.getAttribute("id") == null) {
			session.addAttribute("firstname", "Vous ?");
			session.addAttribute("redirection", "/lesamisdelescalade/auth/login");
		} else {
			session.addAttribute("id", activeSession.getAttribute("id"));
			session.addAttribute("firstname", activeSession.getAttribute("firstname"));
			session.addAttribute("redirection", "/lesamisdelescalade/auth/login");
		}
		
		return "siteList-page";
	}

}