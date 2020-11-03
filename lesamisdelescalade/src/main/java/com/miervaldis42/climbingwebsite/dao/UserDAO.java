package com.miervaldis42.climbingwebsite.dao;

// Imports
import com.miervaldis42.climbingwebsite.entity.User;
import java.util.List;

// DAO
public interface UserDAO {

	public void saveUser(User newUser);

	public List<User> getUsers();

}
