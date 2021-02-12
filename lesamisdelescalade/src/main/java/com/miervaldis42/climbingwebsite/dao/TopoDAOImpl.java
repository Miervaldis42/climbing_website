package com.miervaldis42.climbingwebsite.dao;

// Imports
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miervaldis42.climbingwebsite.entity.Status;
import com.miervaldis42.climbingwebsite.entity.Topo;



@Repository
public class TopoDAOImpl implements TopoDAO {
	@Autowired
	private SessionFactory sessionFactory;

	
	/*
	 * CREATE & UPDATE
	 */
	@Override
	public void saveTopo(Topo newTopo) {
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(newTopo);
	}

	
	
	/*
	 * READ
	 */
	@Override
	public List<Topo> getTopos() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Topo> allToposQuery = currentSession.createQuery("FROM Topo", Topo.class);
		
		List<Topo> allTopos = null;
		if(!allToposQuery.getResultList().isEmpty()) {
			allTopos = allToposQuery.getResultList();
        }
		
		return allTopos;
	}
	
	@Override
	public List<Topo> getToposByOwner(int ownerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Topo> allUserToposQuery = currentSession.createQuery("FROM Topo WHERE owner_id=:id", Topo.class);
		allUserToposQuery.setParameter("id", ownerId);
		
		List<Topo> allUserTopos = null;
		
        if(!allUserToposQuery.getResultList().isEmpty()) {
        	allUserTopos = allUserToposQuery.getResultList();
        }
		
		return allUserTopos;
	}

	@Override
	public List<Topo> getToposBySite(int siteId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Topo> allSiteToposQuery = currentSession.createQuery("FROM Topo WHERE site_id=:id", Topo.class);
		allSiteToposQuery.setParameter("id", siteId);
		
		List<Topo> allSiteTopos = null;
		
        if(!allSiteToposQuery.getResultList().isEmpty()) {
        	allSiteTopos = allSiteToposQuery.getResultList();
        }
		
		return allSiteTopos;
	}
	
	@Override
	public List<Topo> getToposByStatus(Status status) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Topo> allSelectedToposQuery = currentSession.createQuery("FROM Topo WHERE status=:status", Topo.class);
		allSelectedToposQuery.setParameter("status", status);
	
		List<Topo> allSpecificTopos = null;
		
        if(!allSelectedToposQuery.getResultList().isEmpty()) {
        	allSpecificTopos = allSelectedToposQuery.getResultList();
        }
		
		return allSpecificTopos;
	}

	@Override
	public Topo getTopo(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Topo selectedTopo = currentSession.get(Topo.class, id);
		
		return selectedTopo;
	}

	
	
	/*
	 * DELETE
	 */
	@Override
	public void deleteTopo(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query selectedTopo = currentSession.createQuery("DELETE FROM Topo WHERE id=:topoId");
		selectedTopo.setParameter("topoId", id);

		selectedTopo.executeUpdate();
	}

}
