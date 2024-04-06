package com.homely.homelyservices.service;

import java.util.List;

import com.homely.homelyservices.model.User;

public interface UserService {
	
	public void addUser(User user);
	
	
	 public List<User> getUser();
	 
	 public User findUser(User user);
	 
	 public User findEmail(User user);
	 
	 public List<User>findByRoleId(User user);
	 
	 public void updateUser(User user);	
	 
	 public User findByUserId(int userId);
	 
	 public boolean sendEmail(String subject, String message, String to);
	
	
}
