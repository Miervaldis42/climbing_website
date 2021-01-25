package com.miervaldis42.climbingwebsite.service;

// Imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.miervaldis42.climbingwebsite.dao.LengthDAO;
import com.miervaldis42.climbingwebsite.entity.Length;



@Service
public class LengthServiceImpl implements LengthService {
	@Autowired
	private LengthDAO lengthDAO;

	@Override
	@Transactional
	public void saveLength(Length newLength) {
		lengthDAO.saveLength(newLength);
	}

	@Override
	@Transactional
	public List<Length> getLengths() {
		return lengthDAO.getLengths();
	}
	@Override
	@Transactional
	public List<Length> getLengthsBySite(int siteId) {
		return lengthDAO.getLengthsBySite(siteId);
	}
	@Override
	@Transactional
	public List<Length> getLengthsByRoute(int routeId) {
		return lengthDAO.getLengthsByRoute(routeId);
	}
	@Override
	@Transactional
	public Length getLength(int id) {
		return lengthDAO.getLength(id);
	}

	@Override
	@Transactional
	public void deleteLength(int id) {
		lengthDAO.deleteLength(id);	
	}

}