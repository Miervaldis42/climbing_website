package com.miervaldis42.climbingwebsite.dao;

// Imports
import com.miervaldis42.climbingwebsite.entity.User;

import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;


// DAO implementation
@Repository
public class UserDAOImpl implements UserDAO {
	
	// Inject the session factory
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public void saveUser(User newUser) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(newUser);
	}
	
	@Override
	public List<User> getUsers() {
		// Get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Create & execute the query
		Query<User> getUsersQuery = currentSession.createQuery("FROM Users", User.class);
		List<User> users = getUsersQuery.getResultList();
		
		// Return result
		return users;
	}
}
