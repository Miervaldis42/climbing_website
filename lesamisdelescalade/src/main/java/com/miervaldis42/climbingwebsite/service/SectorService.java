package com.miervaldis42.climbingwebsite.service;

// Imports
import java.util.List;
import com.miervaldis42.climbingwebsite.entity.Sector;


public interface SectorService {
	public void saveSector(Sector newSector);
	
	public List<Sector> getSectors();	
	public List<Sector> getSectors(int siteId);	
	public Sector getSector(int id);
	
	public void deleteSector(int id);
}
