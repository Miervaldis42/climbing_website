package com.miervaldis42.climbingwebsite.dao;

// Imports
import com.miervaldis42.climbingwebsite.entity.Sector;
import java.util.*;


public interface SectorDAO {
	public void saveSector(Sector newSector);
	
	public List<Sector> getSectors();
	public List<Sector> getSectors(int siteId);
	public Sector getSector(int id);
	
	public void deleteSector(int id);
}
