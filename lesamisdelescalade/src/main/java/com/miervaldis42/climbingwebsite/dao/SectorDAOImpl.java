package com.miervaldis42.climbingwebsite.dao;

// Imports
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.miervaldis42.climbingwebsite.entity.Sector;



@Repository
public class SectorDAOImpl implements SectorDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	/*
	 * Save & Update
	 */
	@Override
	public void saveSector(Sector newSector) {
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(newSector);
	}
	
	
	
	/*
	 * Read
	 */
	@Override
	public List<Sector> getSectors() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Sector> retrievedAllSectors = currentSession.createQuery("FROM Sector", Sector.class);
		
		List<Sector> allSectors = null;
		if(!retrievedAllSectors.getResultList().isEmpty()) {
        	allSectors = retrievedAllSectors.getResultList();
        }
		
		return allSectors;
	}
	
	@Override
	public List<Sector> getSectors(int siteId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Sector> retrievedAllSectors = currentSession.createQuery("FROM Sector WHERE site_id=:id", Sector.class);
		retrievedAllSectors.setParameter("id", siteId);
		
		List<Sector> allSectors = null;
		
        if(!retrievedAllSectors.getResultList().isEmpty()) {
        	allSectors = retrievedAllSectors.getResultList();
        }
		
		return allSectors;
	}
	
	@Override
	public int countSectorsBySite(int siteId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Long> countSectorsQuery = currentSession.createQuery("SELECT COUNT(s) FROM Sector s WHERE site_id=:id", Long.class);
		countSectorsQuery.setParameter("id", siteId);
		
		int countSiteSectors = ((Long) countSectorsQuery.uniqueResult()).intValue();
		
		return countSiteSectors;
	}
	

	@Override
	public Sector getSector(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Sector selectedSector = currentSession.get(Sector.class, id);
		
		return selectedSector;
	}


	
	/*
	 * Delete
	 */
	@Override
	public void deleteSector(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Sector> selectedSector = currentSession.createQuery("DELETE FROM Sector WHERE id=:sectorId", Sector.class);
		selectedSector.setParameter("sectorId", id);

		selectedSector.executeUpdate();
	}

}
