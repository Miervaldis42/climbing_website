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
	String siteDir = "sites/";
	
	@Autowired
	private SiteService siteService;
	

	
	@RequestMapping("/sites")
	public String showSiteListPage(Model search, Model cards) {		
		// Search bar
		search.addAttribute("quotationDifficulties", Difficulty.EASY.getAllDifficulties());
		
		// Populate model to use for site cards
		List<Site> sites = siteService.getSites();
		setSiteCardInfo(sites, cards);
		
		return siteDir + "siteList-page";
	}
	
	
	@GetMapping("/search")
    public String searchSites(
    	@RequestParam("quotationFilter") String quotationFilter,
    	@RequestParam("tagFilter") String tagFilter,
    	@RequestParam("searchedTerms") String searchedTerms,
    	Model search,
    	Model cards
    ) {		
		// Narrow down site list with user filters
		List<Site> searchedSites = siteService.searchSites(searchedTerms, tagFilter);
		setSiteCardInfo(searchedSites, cards);
		
		if(!quotationFilter.equals("all")) {
			searchedSites.clear();

			Map<Integer, String> siteQuotation = (Map<Integer, String>) cards.getAttribute("quotation");
			List<Integer> filteredSiteIndexes = Difficulty.EASY.filterSitesByQuotationMode(siteQuotation, quotationFilter);
			
			for(int nb: filteredSiteIndexes) {
				searchedSites.add(siteService.getSite(nb));
			}
			setSiteCardInfo(searchedSites, cards);
		}
		
		// Add user chosen filters to search model
		search.addAttribute("keywords", searchedTerms);
		search.addAttribute("chosenTag", tagFilter);
		search.addAttribute("quotationDifficulties", Difficulty.EASY.getAllDifficulties());
		search.addAttribute("chosenQuotationMode", quotationFilter);
		
        return siteDir + "siteList-page";        
    }
	
	
	
	/*
	 * 	Utils
	 */	
	// Set info for each site card
	private void setSiteCardInfo(List<Site> sites, Model cards) {
		Map<Integer, List<Integer>> siteCardsInfo = siteService.getSiteCards(sites);		
		Map<Integer, String> siteQuotation = Difficulty.EASY.getQuotation(siteCardsInfo);
		
		cards.addAttribute("sites", sites);
		cards.addAttribute("infos", siteCardsInfo);
		cards.addAttribute("quotation", siteQuotation);
	}

}