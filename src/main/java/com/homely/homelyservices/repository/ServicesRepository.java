package com.homely.homelyservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.homely.homelyservices.model.ServiceProvider;
import com.homely.homelyservices.model.Services;
import com.homely.homelyservices.model.User;

@Repository
public interface ServicesRepository extends JpaRepository<Services,Integer>{
	
	@Query(value="SELECT * FROM Services s WHERE s.category = :category_id", nativeQuery = true)
	 public List<Services> findServicesByCategory(Integer category_id);
	
}
