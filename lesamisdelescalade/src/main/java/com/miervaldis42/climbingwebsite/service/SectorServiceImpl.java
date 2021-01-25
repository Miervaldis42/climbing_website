package com.miervaldis42.climbingwebsite.service;

// Imports
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.miervaldis42.climbingwebsite.entity.Sector;
import com.miervaldis42.climbingwebsite.dao.SectorDAO;


@Service
public class SectorServiceImpl implements SectorService {
	@Autowired
	private SectorDAO sectorDAO;
	
	
	@Override
	@Transactional
	public void saveSector(Sector newSector) {
		sectorDAO.saveSector(newSector);
	}
	
	
	@Override
	@Transactional
	public List<Sector> getSectors() {
		return sectorDAO.getSectors();
	}
	
	@Override
	@Transactional
	public List<Sector> getSectors(int siteId) {
		return sectorDAO.getSectors(siteId);
	}

	@Override
	@Transactional
	public Sector getSector(int id) {
		return sectorDAO.getSector(id);
	}
	
	
	@Override
	@Transactional
	public void deleteSector(int id) {
		sectorDAO.deleteSector(id);
	}

}
