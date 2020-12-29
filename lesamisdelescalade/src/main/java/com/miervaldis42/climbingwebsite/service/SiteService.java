package com.miervaldis42.climbingwebsite.service;

// Imports
import com.miervaldis42.climbingwebsite.entity.Site;
import java.util.List;
import java.util.Map;


public interface SiteService {

	public List<Site> getSites();
	public Map<Integer, List<Integer>> getSiteCards(List<Site> allSites);
	
	public Site getSite(int id);

}