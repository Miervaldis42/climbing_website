package com.miervaldis42.climbingwebsite.dao;

// Imports
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.miervaldis42.climbingwebsite.entity.Route;



@Repository
public class RouteDAOImpl implements RouteDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	/*
	 * Create & Update
	 */
	@Override
	public void saveRoute(Route newRoute) {
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(newRoute);
	}
	
	
	/*
	 * Read
	 */
	@Override
	public List<Route> getRoutes() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Route> routesQuery = currentSession.createQuery("FROM Route", Route.class);
		List<Route> allRoutes = null;
		
		if(!routesQuery.getResultList().isEmpty()) {
			allRoutes = routesQuery.getResultList();
		}
		
		return allRoutes;
	}
	
	@Override
	public List<Route> getRoutesBySite(int siteId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Route> siteRoutesQuery = currentSession.createQuery("SELECT r FROM Route r INNER JOIN r.sector rs INNER JOIN rs.site s WHERE s.id=:siteId", Route.class);
		siteRoutesQuery.setParameter("siteId", siteId);
		
		List<Route> siteRoutes = null; 
		
		if(!siteRoutesQuery.getResultList().isEmpty()) {
			siteRoutes = siteRoutesQuery.getResultList();
		}
		
		return siteRoutes;
	}

	@Override
	public List<Route> getRoutesBySector(int sectorId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Route> sectorRoutesQuery = currentSession.createQuery("FROM Route WHERE sector_id=:sectorId", Route.class);
		sectorRoutesQuery.setParameter("sectorId", sectorId);
		
		List<Route> sectorRoutes = null;
		if(!sectorRoutesQuery.getResultList().isEmpty()) {
			sectorRoutes = sectorRoutesQuery.getResultList();
		}

		return sectorRoutes;
	}

	@Override
	public Route getRoute(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Route selectedRoute = currentSession.get(Route.class, id);

		return selectedRoute;
	}
	
	
	/*
	 * Utils
	 */
	@Override
	public int countRoutesBySite(int siteId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Long> countRoutesQuery = currentSession.createQuery("SELECT COUNT(r) FROM Route r INNER JOIN r.sector rs INNER JOIN rs.site s WHERE site_id=:id", Long.class);
		countRoutesQuery.setParameter("id", siteId);
		
		int countSiteRoutes = ((Long) countRoutesQuery.uniqueResult()).intValue();
		return countSiteRoutes;
	}
	
	@Override
	public List<String> getQuotationsBySite(int siteId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<String> RouteQuotationsQuery = currentSession.createQuery("SELECT r.quotation FROM Route r INNER JOIN r.sector rs INNER JOIN rs.site s WHERE site_id=:id", String.class);
		RouteQuotationsQuery.setParameter("id", siteId);
		
		List<String> allSiteRouteQuotations = RouteQuotationsQuery.getResultList();
		return allSiteRouteQuotations;
	}


	
	/*
	 * Delete
	 */
	@Override
	public void deleteRoute(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Route> selectedRoute = currentSession.createQuery("DELETE FROM Route WHERE id=:routeId", Route.class);
		selectedRoute.setParameter("routeId", id);

		selectedRoute.executeUpdate();
	}

}
