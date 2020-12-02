package com.miervaldis42.climbingwebsite.dao;

// Imports
import java.util.*;

import com.miervaldis42.climbingwebsite.entity.Route;



public interface RouteDAO {
	public void saveRoute(Route newRoute);
	
	public List<Route> getRoutes();
	public List<Route> getRoutesBySite(int siteId);
	public List<Route> getRoutesBySector(int sectorId);
	public Route getRoute(int id);
	
	public void deleteRoute(int id);
}
