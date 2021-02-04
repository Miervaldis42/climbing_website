package com.miervaldis42.climbingwebsite.controller;

// Imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// Entities
import com.miervaldis42.climbingwebsite.entity.Site;
import com.miervaldis42.climbingwebsite.entity.Length;
import com.miervaldis42.climbingwebsite.entity.Route;
import com.miervaldis42.climbingwebsite.entity.Sector;
import com.miervaldis42.climbingwebsite.entity.Comment;
import com.miervaldis42.climbingwebsite.entity.Difficulty;

import com.miervaldis42.climbingwebsite.service.SiteService;
import com.miervaldis42.climbingwebsite.service.SectorService;
import com.miervaldis42.climbingwebsite.service.RouteService;
import com.miervaldis42.climbingwebsite.service.CommentService;
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
	@Autowired
	private CommentService commentService;


	@GetMapping("/details") 
	public String showSiteDetailsPage(@RequestParam("siteId") int siteId, Model siteDetails) {
		Site site = siteService.getSite(siteId);
		List<Sector> siteSectors = sectorService.getSectors(siteId);
		List<Route> siteRoutes = routeService.getRoutesBySite(siteId);
		List<Length> siteLengths = lengthService.getLengthsBySite(siteId);
		
		// Attributes to model
		siteDetails.addAttribute("site", site);
		siteDetails.addAttribute("sectors", siteSectors);
		siteDetails.addAttribute("routes", siteRoutes);
		siteDetails.addAttribute("lengths", siteLengths);
		siteDetails.addAttribute("quotations", Difficulty.EASY.getEntireStepList());
		
		// Comments & Date
		List<Comment> siteComments = commentService.getCommentsBySite(siteId);
		if(siteComments != null && !siteComments.isEmpty()) {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy, à hh:mm");
			Map<Integer, String> commentCreationDates = new HashMap<Integer, String>();
			for(Comment c : siteComments) {
				commentCreationDates.put(c.getId(), formatter.format(c.getCreatedAt()));
			}
			Map<Integer, String> commentUpdateDates = new HashMap<Integer, String>();
			for(Comment c : siteComments) {
				if(c.getUpdatedAt() != null) {
					commentUpdateDates.put(c.getId(), formatter.format(c.getUpdatedAt()));
				}
			}
			
			// Attributes to model
			siteDetails.addAttribute("comments", siteComments);
			siteDetails.addAttribute("commentCreationDates", commentCreationDates);
			siteDetails.addAttribute("commentUpdateDates", commentUpdateDates);
		}		

		return siteDir + "siteDetails-page";
	}
	
	
	@GetMapping("/editInfo") 
	public String editSiteDetails
		(@RequestParam("siteId") String siteId,
		 @RequestParam("sectorId") Optional<int[]> sectorIds,
		 @RequestParam("sector") Optional<String[]> sectorNames,
		 @RequestParam("routeId") Optional<int[]> routeIds,
		 @RequestParam("route") Optional<String[]> routeNames,
		 @RequestParam("routeQuotation") Optional<String[]> routeQuotations,
		 @RequestParam("routeSector") Optional<int[]> routeSectorIds,
		 @RequestParam("lengthId") Optional<int[]> lengthIds,
		 @RequestParam("length") Optional<String[]> lengthNames,
		 @RequestParam("lengthQuotation") Optional<String[]> lengthQuotations,
		 @RequestParam("lengthRoute") Optional<int[]> lengthRouteIds)
	{
		int id = Integer.parseInt(siteId);
		Site associatedSite = siteService.getSite(id);
		
		// Save sectors
		Sector newSector = null;

		if(sectorIds.isPresent()) {
			String[] existingSectorNames = Arrays.copyOfRange(sectorNames.get(), 0, sectorIds.get().length);
			String[] otherSectorNames = Arrays.copyOfRange(sectorNames.get(), sectorIds.get().length, sectorNames.get().length);
			
			for(int i=0; i < sectorIds.get().length; i++) {	
				newSector = sectorService.getSector(sectorIds.get()[i]);
				newSector.setName(!existingSectorNames[i].isEmpty() ? existingSectorNames[i] : "X-File n°" + i);
				
				sectorService.saveSector(newSector);
			}
			
			for(int i=0; i < otherSectorNames.length; i++) {
				newSector = new Sector();
				newSector.setSite(associatedSite);
				newSector.setName(!otherSectorNames[i].isEmpty() ? otherSectorNames[i] : "X-File n°" + i);

				sectorService.saveSector(newSector);
			}
			
		} else {
			for(int i=0; i < sectorNames.get().length; i++) {
				newSector = new Sector();
				newSector.setSite(associatedSite);
				newSector.setName(!sectorNames.get()[i].isEmpty() ? sectorNames.get()[i] : "X-File n°" + i);

				sectorService.saveSector(newSector);
			}
		}
		
		
		// Save routes
		Route newRoute = null;

		if(routeIds.isPresent()) {			
			String[] existingRouteNames = Arrays.copyOfRange(routeNames.get(), 0, routeIds.get().length);
			String[] otherRouteNames = Arrays.copyOfRange(routeNames.get(), routeIds.get().length, routeNames.get().length);
			String[] existingRouteQuotations = Arrays.copyOfRange(routeQuotations.get(), 0, routeIds.get().length);
			String[] otherRouteQuotations = Arrays.copyOfRange(routeQuotations.get(), routeIds.get().length, routeNames.get().length);
			
			for(int i=0; i < routeIds.get().length; i++) {	
				newRoute = routeService.getRoute(routeIds.get()[i]);
				newRoute.setName(!existingRouteNames[i].isEmpty() ? existingRouteNames[i] : "X-File n°" + i);
				newRoute.setQuotation(existingRouteQuotations[i]);
				
				routeService.saveRoute(newRoute);
			}
			
			for(int i=0; i < otherRouteNames.length; i++) {
				newRoute = new Route();
				newRoute.setSector(sectorService.getSector(routeSectorIds.get()[i]));
				newRoute.setName(!otherRouteNames[i].isEmpty() ? otherRouteNames[i] : "X-File n°" + i);		
				newRoute.setQuotation(otherRouteQuotations[i]);

				routeService.saveRoute(newRoute);
			}
		} else {
			for(int i=0; i < routeNames.get().length; i++) {
				newRoute = new Route();
				newRoute.setSector(sectorService.getSector(routeSectorIds.get()[i]));
				newRoute.setName(!routeNames.get()[i].isEmpty() ? routeNames.get()[i] : "X-File n°" + i);
				newRoute.setQuotation(routeQuotations.get()[i]);

				routeService.saveRoute(newRoute);
			}
		}
		
		
		// Save lengths
		Length newLength = null;

		if(lengthIds.isPresent()) {			
			String[] existingLengthNames = Arrays.copyOfRange(lengthNames.get(), 0, lengthIds.get().length);
			String[] otherLengthNames = Arrays.copyOfRange(lengthNames.get(), lengthIds.get().length, lengthNames.get().length);
			String[] existingLengthQuotations = Arrays.copyOfRange(lengthQuotations.get(), 0, lengthIds.get().length);
			String[] otherLengthQuotations = Arrays.copyOfRange(lengthQuotations.get(), lengthIds.get().length, lengthNames.get().length);
			
			for(int i=0; i < lengthIds.get().length; i++) {	
				newLength = lengthService.getLength(lengthIds.get()[i]);
				newLength.setName(!existingLengthNames[i].isEmpty() ? existingLengthNames[i] : "X-File n°" + i);
				newLength.setQuotation(existingLengthQuotations[i]);
				
				lengthService.saveLength(newLength);
			}
			
			for(int i=0; i < otherLengthNames.length; i++) {
				newLength = new Length();
				newLength.setRoute(routeService.getRoute(lengthRouteIds.get()[i]));
				newLength.setName(!otherLengthNames[i].isEmpty() ? otherLengthNames[i] : "X-File n°" + i);		
				newLength.setQuotation(otherLengthQuotations[i]);

				lengthService.saveLength(newLength);
			}
		} else {
			for(int i=0; i < lengthNames.get().length; i++) {
				newLength = new Length();
				newLength.setRoute(routeService.getRoute(lengthRouteIds.get()[i]));
				newLength.setName(!lengthNames.get()[i].isEmpty() ? lengthNames.get()[i] : "X-File n°" + i);		
				newLength.setQuotation(lengthQuotations.get()[i]);

				lengthService.saveLength(newLength);
			}
		}

		return "redirect:/details?siteId="+id;
	}

}
