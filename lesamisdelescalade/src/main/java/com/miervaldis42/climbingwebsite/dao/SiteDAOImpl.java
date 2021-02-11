package com.miervaldis42.climbingwebsite.dao;

// Imports
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.List;

import com.miervaldis42.climbingwebsite.entity.Site;


@Repository
public class SiteDAOImpl implements SiteDAO {
	@Autowired
	private SessionFactory sessionFactory;

	
	/*
	 * CREATE
	 */
	public void saveSite(Site newSite) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(newSite);
	}
	
	
	
	/*
	 * READ
	 */
	
	@Override
	public List<Site> getSites() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Site> allSites = currentSession.createQuery("FROM Site", Site.class);
		List<Site> sites = allSites.getResultList();
		
		return sites;
	}

	@Override
	public Site getSite(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Site selectedSite = currentSession.get(Site.class, id);
		
		return selectedSite;
	}
	
	@Override
    public List<Site> searchSites(String searchedTerms, String tagFilter) {
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query<Site> searchQuery = null;
        String HQLRequest = "FROM Site s";
        
        if(searchedTerms.trim().length() > 0 || !tagFilter.equals("all")) {
        	HQLRequest = HQLRequest.concat(" WHERE ");

	        if (searchedTerms.trim().length() > 0) {
	        	String keywordsParameter = "(s.name LIKE '%" + searchedTerms.toLowerCase() + "%' OR s.location LIKE '%" + searchedTerms.toLowerCase() + "%')";
	        	HQLRequest = HQLRequest.concat(keywordsParameter);
	        } 
	        
	        if(searchedTerms.trim().length() > 0 && !tagFilter.equals("all")) {
	        	HQLRequest = HQLRequest.concat(" AND ");
	        }
	        
	        if(!tagFilter.equals("all")) {
	        	String keywordsParameter = "s.tag=" + Boolean.parseBoolean(tagFilter);
	        	HQLRequest = HQLRequest.concat(keywordsParameter);
	        }
        }
        
        searchQuery = currentSession.createQuery(HQLRequest, Site.class);        
        List<Site> sites = searchQuery.getResultList();

        return sites;
    }
	
	
	
	/*
	 * DELETE
	 */
	public void deleteSite(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query selectedSite = currentSession.createQuery("DELETE FROM Site WHERE id=:siteId");
		selectedSite.setParameter("siteId", id);

		selectedSite.executeUpdate();
	}
}
