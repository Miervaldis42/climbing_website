package com.miervaldis42.climbingwebsite.dao;

// Imports
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public void saveRoute(Route newRoute) {
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(newRoute);
	}
	
	
	/*
	 * Read
	 */
	@Override
	@Transactional
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
	@Transactional
	public List<Route> getRoutesBySite(int siteId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Route> siteRoutesQuery = currentSession.createQuery("FROM Route WHERE site_id = :siteId", Route.class);
		siteRoutesQuery.setParameter("siteId", siteId);
		
		List<Route> siteRoutes = null; 
		
		if(!siteRoutesQuery.getResultList().isEmpty()) {
			siteRoutes = siteRoutesQuery.getResultList();
		}
		
		return siteRoutes;
	}

	@Override
	@Transactional
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
	@Transactional
	public Route getRoute(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Route selectedRoute = currentSession.get(Route.class, id);

		return selectedRoute;
	}

	
	/*
	 * Delete
	 */
	@Override
	@Transactional
	public void deleteRoute(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Route> selectedRoute = currentSession.createQuery("DELETE FROM Route WHERE id=:routeId", Route.class);
		selectedRoute.setParameter("routeId", id);

		selectedRoute.executeUpdate();
	}

}
