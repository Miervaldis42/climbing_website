package com.miervaldis42.climbingwebsite.dao;

// Imports
import com.miervaldis42.climbingwebsite.entity.Site;
import java.util.List;


public interface SiteDAO {
	
	public List<Site> getSites();
	public Site getSite(int id);

}
