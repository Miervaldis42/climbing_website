package com.miervaldis42.climbingwebsite.service;

// Imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import com.miervaldis42.climbingwebsite.entity.Site;
import com.miervaldis42.climbingwebsite.dao.SiteDAO;



@Service
public class SiteServiceImpl implements SiteService {
	@Autowired
	private SiteDAO siteDAO;
	
	
	// Get info from all sites from "ClimbingSites" table in database
	@Override
	@Transactional
	public List<Site> getSites() {
		List<Site> sites = siteDAO.getSites();
		
		return sites;
	}

	
	// Get info from a specific site from "ClimbingSite s" table in database
	@Override
	@Transactional
	public Site getSite(int id) {
		Site selectedSite = siteDAO.getSite(id);
		
		return selectedSite;
	}

}