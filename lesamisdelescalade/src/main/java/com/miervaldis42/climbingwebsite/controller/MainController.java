package com.miervaldis42.climbingwebsite.controller;

// Imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

import com.miervaldis42.climbingwebsite.entity.Difficulty;
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
		List<Site> sites = siteService.getSites();
		setSiteCardInfo(sites, cards);		
		
		return "siteList-page";
	}
	
	
	@GetMapping("/search")
    public String searchSites(@RequestParam("searchedTerms") String searchedTerms, Model cards) {
		List<Site> searchedSites = siteService.searchSites(searchedTerms);
		setSiteCardInfo(searchedSites, cards);
		
        return "siteList-page";        
    }
	
	
	// Set info for each site card
	private void setSiteCardInfo(List<Site> sites, Model cards) {
		Map<Integer, List<Integer>> siteCardsInfo = siteService.getSiteCards(sites);		
		Map<Integer, String> siteQuotation = Difficulty.EASY.getQuotation(siteCardsInfo);
		
		cards.addAttribute("sites", sites);
		cards.addAttribute("infos", siteCardsInfo);
		cards.addAttribute("quotation", siteQuotation);
	}

}