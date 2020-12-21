package com.miervaldis42.climbingwebsite.service;

// Imports
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miervaldis42.climbingwebsite.dao.RouteDAO;
import com.miervaldis42.climbingwebsite.entity.Route;


@Service
public class RouteServiceImpl implements RouteService {
	@Autowired
	private RouteDAO routeDAO;

	@Override
	@Transactional
	public void saveRoute(Route newRoute) {
		routeDAO.saveRoute(newRoute);
	}

	@Override
	@Transactional
	public List<Route> getRoutes() {
		return routeDAO.getRoutes();
	}

	@Override
	@Transactional
	public List<Route> getRoutesBySite(int siteId) {
		return routeDAO.getRoutesBySite(siteId);
	}

	@Override
	@Transactional
	public List<Route> getRoutesBySector(int sectorId) {
		return routeDAO.getRoutesBySector(sectorId);
	}

	@Override
	@Transactional
	public Route getRoute(int id) {
		return routeDAO.getRoute(id);
	}

	@Override
	@Transactional
	public void deleteRoute(int id) {
		routeDAO.deleteRoute(id);
	}
}