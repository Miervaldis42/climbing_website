package com.miervaldis42.climbingwebsite.dao;

// Imports
import java.util.List;

import com.miervaldis42.climbingwebsite.entity.Status;
import com.miervaldis42.climbingwebsite.entity.Topo;


// DAO
public interface TopoDAO {

	/* Create */
	public void saveTopo(Topo newTopo);

	/* Get */
	public List<Topo> getTopos();
	public List<Topo> getToposByOwner(int ownerId);
	public List<Topo> getToposBySite(int siteId);
	public List<Topo> getToposByStatus(Status status);
	public Topo getTopo(int id);

	/* Delete */
	public void deleteTopo(int id);

}
