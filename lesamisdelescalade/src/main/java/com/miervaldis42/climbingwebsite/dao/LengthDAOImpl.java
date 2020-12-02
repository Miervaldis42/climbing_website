package com.miervaldis42.climbingwebsite.dao;

// Imports
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.List;

import com.miervaldis42.climbingwebsite.entity.Length;



@Repository
public class LengthDAOImpl implements LengthDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	/*
	 * Create & Update
	 */
	@Override
	public void saveLength(Length newLength) {
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(newLength);
	}
	
	
	
	/*
	 * Read
	 */
	@Override
	@Transactional
	public List<Length> getLengths() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Length> allLengthsQuery = currentSession.createQuery("FROM Length", Length.class);
		
		List<Length> allLengths = null;
		if(!allLengthsQuery.getResultList().isEmpty()) {
			allLengths = allLengthsQuery.getResultList();
		}
		
		return allLengths;
	}
	
	@Override
	@Transactional
	public List<Length> getLengthsBySite(int siteId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Length> siteLengthsQuery = currentSession.createQuery("FROM Length WHERE site_id = :siteId", Length.class);
		siteLengthsQuery.setParameter("siteId", siteId);
		
		List<Length> siteLengths = null;
		if(!siteLengthsQuery.getResultList().isEmpty()) {
			siteLengths = siteLengthsQuery.getResultList();
		}
		
		return siteLengths;
	}

	@Override
	@Transactional
	public List<Length> getLengthsByRoute(int routeId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Length> routeLengthsQuery = currentSession.createQuery("FROM Length WHERE route_id=:routeId", Length.class);
		routeLengthsQuery.setParameter("routeId", routeId);
		
		List<Length> routeLengths = null;
		if(!routeLengthsQuery.getResultList().isEmpty()) {
			routeLengths = routeLengthsQuery.getResultList();
		}
		
		return routeLengths;
	}

	@Override
	@Transactional
	public Length getLength(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Length selectedLength = currentSession.get(Length.class, id);

		return selectedLength;
	}
	
	
	
	/*
	 * Delete
	 */
	@Override
	@Transactional
	public void deleteLength(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Length> selectedLength = currentSession.createQuery("DELETE FROM Length WHERE id=:lengthId", Length.class);
		selectedLength.setParameter("lengthId", id);

		selectedLength.executeUpdate();
	}

}
 