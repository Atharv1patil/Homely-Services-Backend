package com.homely.homelyservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homely.homelyservices.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	public User findByEmailAndPassword(String email,String password);
	public User findByEmail(String email);
	public List<User> findByRoleId(int roleId);
	public User findByUserid(int userId);
	public User findByName(String name);
	public User findByname(String name);
	

}
