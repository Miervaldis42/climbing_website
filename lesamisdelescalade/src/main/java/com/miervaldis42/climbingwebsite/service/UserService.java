package com.miervaldis42.climbingwebsite.service;

// Imports
import com.miervaldis42.climbingwebsite.entity.User;

import java.util.List;


// Service
public interface UserService {
	public void saveUser(User newUser);
	
	public User getUserByCredentials(User unknownUser);
	public List<User> getUsers();
}
