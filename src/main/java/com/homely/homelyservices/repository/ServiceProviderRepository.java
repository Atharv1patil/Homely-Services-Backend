package com.homely.homelyservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.homely.homelyservices.model.ServiceProvider;
import com.homely.homelyservices.model.User;

import jakarta.xml.ws.Service;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider,Integer>{
	@Query(value="SELECT * FROM Service_Provider s WHERE s.specialization = :specialization", nativeQuery = true)
	List<ServiceProvider> findBySpecialization(@Param("specialization") String specialization);
	public ServiceProvider findByEmailAndPassword(String email,String password);
	public ServiceProvider findByEmail(String email);
//	public  ServiceProvider findServiceProvider(ServiceProvider serviceProvider);
	public ServiceProvider findByname(String name);
//	@Query("SELECT s FROM ServiceProvider s WHERE s.actualFieldName = :name")
//	public List<ServiceProvider> findByServiceProviderName(String name);
	public List<ServiceProvider> findByName(String name);


	
	
}
