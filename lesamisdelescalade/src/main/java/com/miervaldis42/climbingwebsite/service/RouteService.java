package com.miervaldis42.climbingwebsite.service;

// Imports
import com.miervaldis42.climbingwebsite.entity.Route;
import java.util.List;


public interface RouteService {
	public void saveRoute(Route newRoute);
	
	public List<Route> getRoutes();
	public List<Route> getRoutesBySite(int siteId);
	public List<Route> getRoutesBySector(int sectorId);
	public Route getRoute(int id);
	
	public void deleteRoute(int id);
}
