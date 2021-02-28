package com.miervaldis42.climbingwebsite.service;

// Imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.miervaldis42.climbingwebsite.entity.Site;
import com.miervaldis42.climbingwebsite.enums.Difficulty;
import com.miervaldis42.climbingwebsite.dao.SiteDAO;
import com.miervaldis42.climbingwebsite.dao.SectorDAO;
import com.miervaldis42.climbingwebsite.dao.RouteDAO;
import com.miervaldis42.climbingwebsite.dao.LengthDAO;



@Service
public class SiteServiceImpl implements SiteService {
	/*
	 * Autowired
	 */
	@Autowired
	private SiteDAO siteDAO;
	
	@Autowired
	private SectorDAO sectorDAO;
	
	@Autowired
	private RouteDAO routeDAO;
	
	@Autowired
	private LengthDAO lengthDAO;
	
	
	/*
	 * CREATE
	 */
	@Override
	@Transactional
	public void saveSite(Site newSite) {
		siteDAO.saveSite(newSite);
	}
	
	
	/*
	 * READ
	 */
	@Override
	@Transactional
	public List<Site> getSites() {
		List<Site> sites = siteDAO.getSites();
		
		return sites;
	}
	
	@Override
	@Transactional
	public Map<Integer, List<Integer>> getSiteCards(List<Site> allSites) {
		// siteId, <siteQuotationIndex,sector,route,length>
		Map<Integer, List<Integer>> siteInfoCards = new HashMap<>();
		
		for(Site site : allSites) {
			int siteId = site.getId();
			List<Integer> siteCounts = new ArrayList<Integer>(4);
			
			// Site average quotation
			List<String> allRouteQuotationsBySite = routeDAO.getQuotationsBySite(siteId);
			List<String> allLengthQuotationsBySite = lengthDAO.getQuotationsBySite(siteId);
			List<String> allSiteQuotations = Stream.concat(allRouteQuotationsBySite.stream(), allLengthQuotationsBySite.stream())
                    .collect(Collectors.toList());
			siteCounts.add(Difficulty.EASY.getAvgQuotationIndex(allSiteQuotations));
			
			// Counts
			int sectorCount = sectorDAO.countSectorsBySite(siteId);
			siteCounts.add(sectorCount);
			
			int routeCount = routeDAO.countRoutesBySite(siteId);
			siteCounts.add(routeCount);
			
			int lengthCount = lengthDAO.countLengthsBySite(siteId);
			siteCounts.add(lengthCount);
			
			// Info for Site cards
			siteInfoCards.put(siteId, siteCounts);
		}

		return siteInfoCards;
	}


	@Override
	@Transactional
	public Site getSite(int id) {
		Site selectedSite = siteDAO.getSite(id);
		
		return selectedSite;
	}

	@Override
	@Transactional
	public List<Site> searchSites(String searchedTerms, String tagFilter) {
		List<Site> retrievedSites = siteDAO.searchSites(searchedTerms, tagFilter);
		return retrievedSites;
	}
	
	
	
	/*
	 * Delete
	 */
	@Override
	@Transactional
	public void deleteSite(int id) {
		siteDAO.deleteSite(id);
	}

}