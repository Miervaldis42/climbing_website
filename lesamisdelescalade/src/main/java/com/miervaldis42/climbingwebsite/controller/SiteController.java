package com.miervaldis42.climbingwebsite.controller;

//Imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

// Entities
import com.miervaldis42.climbingwebsite.entity.Site;
import com.miervaldis42.climbingwebsite.entity.Length;
import com.miervaldis42.climbingwebsite.entity.Route;
import com.miervaldis42.climbingwebsite.entity.Sector;
import com.miervaldis42.climbingwebsite.entity.Difficulty;

import com.miervaldis42.climbingwebsite.service.SiteService;
import com.miervaldis42.climbingwebsite.service.SectorService;
import com.miervaldis42.climbingwebsite.service.RouteService;
import com.miervaldis42.climbingwebsite.service.LengthService;



@Controller
public class SiteController {
	String siteDir = "sites/";

	@Autowired
	private SiteService siteService;
	@Autowired
	private SectorService sectorService;
	@Autowired
	private RouteService routeService;
	@Autowired
	private LengthService lengthService;
	


	@GetMapping("/details") 
	public String showSiteDetailsPage(@RequestParam("siteId") int siteId, Model siteDetails) {
		Site site = siteService.getSite(siteId);
		List<Sector> siteSectors = sectorService.getSectors(siteId);
		List<Route> siteRoutes = routeService.getRoutesBySite(siteId);
		List<Length> siteLengths = lengthService.getLengthsBySite(siteId);
		
		// Attributes to models
		siteDetails.addAttribute("site", site);
		siteDetails.addAttribute("sectors", siteSectors);
		siteDetails.addAttribute("routes", siteRoutes);
		siteDetails.addAttribute("lengths", siteLengths);
		siteDetails.addAttribute("quotations", Difficulty.EASY.getEntireStepList());

		return siteDir + "siteDetails-page";
	}

}
