package com.miervaldis42.climbingwebsite.controller;

// Imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Map;

import com.miervaldis42.climbingwebsite.entity.Site;
import com.miervaldis42.climbingwebsite.service.SiteService;


@Controller
public class MainController {
	@Autowired
	private SiteService siteService;
	
	@RequestMapping("/sites")
	public String showSiteListPage(HttpSession activeSession, Model session, Model cards) {	
		
		// Check if a user is currently in session
		if(activeSession.getAttribute("id") == null) {
			session.addAttribute("firstname", "Vous ?");
			session.addAttribute("redirection", "/lesamisdelescalade/auth/login");
		} else {
			session.addAttribute("id", activeSession.getAttribute("id"));
			session.addAttribute("firstname", activeSession.getAttribute("firstname"));
			session.addAttribute("redirection", "/lesamisdelescalade/auth/login");
		}
		
		// Populate model to use for site cards
		List<Site> allSites = siteService.getSites();
		Map<Integer, List<Integer>> siteCardsInfo = siteService.getSiteCards(allSites);
		cards.addAttribute("sites", allSites);
		cards.addAttribute("infos", siteCardsInfo);
		
		return "siteList-page";
	}

}