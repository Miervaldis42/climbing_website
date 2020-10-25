package com.miervaldis42.climbingwebsite.dao;

// Imports
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;
import org.apache.commons.codec.binary.Hex;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.miervaldis42.climbingwebsite.helper.*;
import com.miervaldis42.climbingwebsite.entity.User;



/* DAO implementation */
@Repository
public class UserDAOImpl implements UserDAO {
	
	// Class to use the hashing method
	HashPassword hasherMachine = new HashPassword();
	
	// Inject the session factory
	@Autowired
	private SessionFactory sessionFactory;


	/*
	 * Methods for CRU
	 */
	@Override
	public void saveUser(User newUser) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Hashing password
		byte[] hashedBytes = hasherMachine.hashPassword(newUser.getPassword());
		String hashedPassword = Hex.encodeHexString(hashedBytes);
	    newUser.setPassword(hashedPassword);
		
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
