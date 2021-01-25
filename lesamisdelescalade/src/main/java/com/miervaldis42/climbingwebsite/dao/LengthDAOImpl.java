package com.miervaldis42.climbingwebsite.dao;

// Imports
import org.springframework.stereotype.Repository;
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
	public List<Length> getLengthsBySite(int siteId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
//		SQL: FROM climbing_website_db.lengths INNER JOIN climbing_website_db.routes INNER JOIN climbing_website_db.sectors INNER JOIN climbing_website_db.sites WHERE climbing_website_db.lengths.route_id = climbing_website_db.routes.id AND climbing_website_db.routes.sector_id = climbing_website_db.sectors.id AND climbing_website_db.sectors.site_id = climbing_website_db.sites.id AND climbing_website_db.sites.id = '2';
		Query<Length> siteLengthsQuery = currentSession.createQuery("SELECT l FROM Length l INNER JOIN l.route lr INNER JOIN lr.sector lrs INNER JOIN lrs.site s WHERE s.id=:siteId", Length.class);
		siteLengthsQuery.setParameter("siteId", siteId);
		
		List<Length> siteLengths = null;
		if(!siteLengthsQuery.getResultList().isEmpty()) {
			siteLengths = siteLengthsQuery.getResultList();
		}
		
		return siteLengths;
	}

	@Override
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
	public Length getLength(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Length selectedLength = currentSession.get(Length.class, id);

		return selectedLength;
	}
	
	
	/*
	 * Utils
	 */
	@Override
	public int countLengthsBySite(int siteId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Long> countLengthsQuery = currentSession.createQuery("SELECT COUNT(l) FROM Length l INNER JOIN l.route lr INNER JOIN lr.sector lrs INNER JOIN lrs.site s WHERE site_id=:id", Long.class);
		countLengthsQuery.setParameter("id", siteId);
		
		int countSiteLengths = ((Long) countLengthsQuery.uniqueResult()).intValue();
		return countSiteLengths;
	}
	
	@Override
	public List<String> getQuotationsBySite(int siteId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<String> LengthQuotationsQuery = currentSession.createQuery("SELECT l.quotation FROM Length l INNER JOIN l.route lr INNER JOIN lr.sector lrs INNER JOIN lrs.site s WHERE site_id=:id", String.class);
		LengthQuotationsQuery.setParameter("id", siteId);
		
		List<String> allSiteLengthQuotations = LengthQuotationsQuery.getResultList();
		return allSiteLengthQuotations;
	}
	
	
	
	/*
	 * Delete
	 */
	@Override
	public void deleteLength(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Length> selectedLength = currentSession.createQuery("DELETE FROM Length WHERE id=:lengthId", Length.class);
		selectedLength.setParameter("lengthId", id);

		selectedLength.executeUpdate();
	}

}
 