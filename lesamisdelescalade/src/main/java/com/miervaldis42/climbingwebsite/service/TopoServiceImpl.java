package com.miervaldis42.climbingwebsite.service;

// Imports
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miervaldis42.climbingwebsite.dao.TopoDAO;
import com.miervaldis42.climbingwebsite.entity.Topo;


@Service
public class TopoServiceImpl implements TopoService {
	@Autowired
	private TopoDAO topoDAO;

	
	@Override
	@Transactional
	public void saveTopo(Topo newTopo) {
		topoDAO.saveTopo(newTopo);
	}

	
	
	@Override
	@Transactional
	public List<Topo> getTopos() {
		return topoDAO.getTopos();
	}
	
	@Override
	@Transactional
	public List<Topo> getToposByOwner(int ownerId) {
		return topoDAO.getToposByOwner(ownerId);
	}

	@Override
	@Transactional
	public List<Topo> getToposBySite(int siteId) {
		return topoDAO.getToposBySite(siteId);
	}

	@Override
	@Transactional
	public Topo getTopo(int id) {
		return topoDAO.getTopo(id);
	}

	
	
	@Override
	@Transactional
	public void deleteTopo(int id) {
		topoDAO.deleteTopo(id);
	}

}
