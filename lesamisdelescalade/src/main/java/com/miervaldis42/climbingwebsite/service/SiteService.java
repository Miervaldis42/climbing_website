package com.miervaldis42.climbingwebsite.service;

// Imports
import com.miervaldis42.climbingwebsite.entity.Site;
import java.util.List;


public interface SiteService {

	public List<Site> getSites();
	public Site getSite(int id);

}