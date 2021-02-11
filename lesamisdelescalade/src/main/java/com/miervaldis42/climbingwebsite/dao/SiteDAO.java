package com.miervaldis42.climbingwebsite.dao;

// Imports
import com.miervaldis42.climbingwebsite.entity.Site;
import java.util.List;


public interface SiteDAO {
	public void saveSite(Site newSite);
	
	public List<Site> getSites();
	public List<Site> searchSites(String searchedTerms, String tagFilter);
	public Site getSite(int id);

	public void deleteSite(int id);
}
