package com.miervaldis42.climbingwebsite.dao;

// Imports
import com.miervaldis42.climbingwebsite.entity.Sector;
import java.util.*;


public interface SectorDAO {
	// Save
	public void saveSector(Sector newSector);
	
	
	// Read
	public List<Sector> getSectors();
	public List<Sector> getSectors(int siteId);
	public int countSectorsBySite(int siteId);
	
	public Sector getSector(int id);
	
	
	// Delete
	public void deleteSector(int id);
}
