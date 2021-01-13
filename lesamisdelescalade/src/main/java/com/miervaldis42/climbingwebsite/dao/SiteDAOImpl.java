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
        if(searchedTerms.trim().length() == 0 && tagFilter.equals("all")) {
        	// If searchedTerms is empty => Get all sites
        	searchQuery = currentSession.createQuery("FROM Site", Site.class);
        } else if (searchedTerms.trim().length() == 0) {
        	searchQuery = currentSession.createQuery("FROM Site s WHERE s.tag=:tagFilter", Site.class);
        	searchQuery.setParameter("tagFilter", Boolean.parseBoolean(tagFilter));
        } else {
        	searchQuery = currentSession.createQuery("FROM Site s WHERE s.name LIKE :keywords OR s.location LIKE :keywords AND s.tag=:tagFilter", Site.class);
        	searchQuery.setParameter("keywords", "%" + searchedTerms.toLowerCase() + "%");
        	searchQuery.setParameter("tagFilter", Boolean.parseBoolean(tagFilter));
        }
        
        List<Site> sites = searchQuery.getResultList();
        return sites;
    }

}
