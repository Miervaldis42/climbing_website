package com.miervaldis42.climbingwebsite.service;

// Imports
import com.miervaldis42.climbingwebsite.entity.User;
import com.miervaldis42.climbingwebsite.dao.UserDAO;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {
	
	// Inject User DAO
	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public void saveUser(User newUser) {
		userDAO.saveUser(newUser);
	}

	@Override
	@Transactional
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

}
