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
    public List<Site> searchSites(String searchedTerms) {
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query<Site> query = null;
        if (searchedTerms != null && searchedTerms.trim().length() > 0) {

            // search for name or location
        	query = currentSession.createQuery("FROM Site s WHERE s.name LIKE :search OR s.location LIKE :search", Site.class);
        	query.setParameter("search", "%" + searchedTerms.toLowerCase() + "%");

        } else {
            // if searchedTerms is empty => Get all sites
        	query = currentSession.createQuery("FROM Site", Site.class);            
        }
        
        List<Site> sites = query.getResultList();
        return sites;
        
    }

}
