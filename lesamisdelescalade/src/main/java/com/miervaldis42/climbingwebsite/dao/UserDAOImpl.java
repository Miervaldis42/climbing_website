package com.miervaldis42.climbingwebsite.dao;

// Imports
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Objects;
import org.apache.commons.codec.binary.Hex;

// Entities
import com.miervaldis42.climbingwebsite.helper.AuthHelper;
import com.miervaldis42.climbingwebsite.entity.User;



@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	// Helper class
	AuthHelper hasherMachine = new AuthHelper();



	/*
	 * Methods for CRUD
	 */
	
	// Create method
	@Override
	public void saveUser(User newUser, Boolean creation) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		if(creation) {
			// Hashing password
			byte[] hashedBytes = hasherMachine.hashPassword(newUser.getPassword());
			String hashedPassword = Hex.encodeHexString(hashedBytes);
		    newUser.setPassword(hashedPassword);
		}
		
		currentSession.saveOrUpdate(newUser);
	}
	
	
	// Read methods
	@Override
	public Boolean checkEmailExists(String providedEmail) {
		Boolean exist;
		
		Session currentSession = sessionFactory.getCurrentSession();
        Query<User> matchFound = currentSession.createQuery("FROM User u WHERE u.email=:email", User.class);
        matchFound.setParameter("email", providedEmail);
		
        if(matchFound.getResultList().isEmpty()) {
        	exist = false; 
        } else {
        	exist = true;
        }
        
		return exist; 
	}
	
	@Override
    public User getUserByCredentials(User unknownUser) {
		// Hash given password
		byte[] hashedBytes = hasherMachine.hashPassword(unknownUser.getPassword());
		String hashedPassword = Hex.encodeHexString(hashedBytes);
		
		unknownUser.setPassword(hashedPassword);
	    

	    // Hibernate transaction
        Session currentSession = sessionFactory.getCurrentSession();

        Query<User> matchFound = currentSession.createQuery("FROM User u WHERE u.email=:email AND u.password=:pwd", User.class);
        matchFound.setParameter("email", unknownUser.getEmail());
        matchFound.setParameter("pwd", unknownUser.getPassword());

        User user = null;
        if(!matchFound.getResultList().isEmpty()) {
        	user = matchFound.getSingleResult();
        }

        return user;
    }
	
	@Override
	public List<User> getUsers() {
		// Get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Create & execute the query
		Query<User> getUsersQuery = currentSession.createQuery("FROM User", User.class);
		List<User> users = getUsersQuery.getResultList();
		
		// Return result
		return users;
	}
	
	@Override
	public User getUser(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		User selectedUser = currentSession.get(User.class, id);
		
		return selectedUser;
	}

	
	// Delete method
	@Override
	public void deleteUser(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query selectedUser = currentSession.createQuery("DELETE FROM User WHERE id=:userId");
		selectedUser.setParameter("userId", id);

		selectedUser.executeUpdate();
	}
}