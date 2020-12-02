package com.miervaldis42.climbingwebsite.dao;

// Imports
import java.util.List;

import com.miervaldis42.climbingwebsite.entity.Length;



public interface LengthDAO {
	public void saveLength(Length newLength);
	
	public List<Length> getLengths();
	public List<Length> getLengthsBySite(int siteId);
	public List<Length> getLengthsByRoute(int routeId);
	public Length getLength(int id);
	
	public void deleteLength(int id);
}