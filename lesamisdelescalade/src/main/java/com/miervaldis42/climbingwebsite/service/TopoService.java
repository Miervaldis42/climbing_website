package com.miervaldis42.climbingwebsite.service;

//Imports
import java.util.List;

import com.miervaldis42.climbingwebsite.entity.Topo;
import com.miervaldis42.climbingwebsite.enums.Status;


// Service
public interface TopoService {
	
	public void saveTopo(Topo newTopo);

	public List<Topo> getTopos();
	public List<Topo> getToposByOwner(int ownerId);
	public List<Topo> getToposBySite(int siteId);
	public List<Topo> getToposByStatus(Status status);
	public Topo getTopo(int id);
	
	public void deleteTopo(int id);

}
