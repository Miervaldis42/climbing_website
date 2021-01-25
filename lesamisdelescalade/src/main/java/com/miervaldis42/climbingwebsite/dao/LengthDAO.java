package com.miervaldis42.climbingwebsite.dao;

// Imports
import java.util.List;

import com.miervaldis42.climbingwebsite.entity.Length;


public interface LengthDAO {
	// Create & Update
	public void saveLength(Length newLength);
	
	// Read
	public List<Length> getLengths();
	public List<Length> getLengthsBySite(int siteId);
	public List<Length> getLengthsByRoute(int routeId);
	public Length getLength(int id);
	
	// Utils
	public int countLengthsBySite(int siteId);
	public List<String> getQuotationsBySite(int siteId);
	
	// Delete
	public void deleteLength(int id);
}