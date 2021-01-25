package com.miervaldis42.climbingwebsite.dao;

// Imports
import java.util.*;

import com.miervaldis42.climbingwebsite.entity.Route;



public interface RouteDAO {
	// Save
	public void saveRoute(Route newRoute);
	
	
	// Read
	public List<Route> getRoutes();
	
	public List<Route> getRoutesBySite(int siteId);	
	public List<Route> getRoutesBySector(int sectorId);
	public Route getRoute(int id);
	
	// Utils
	public int countRoutesBySite(int siteId);
	public List<String> getQuotationsBySite(int siteId);
	
	// Delete
	public void deleteRoute(int id);

}
