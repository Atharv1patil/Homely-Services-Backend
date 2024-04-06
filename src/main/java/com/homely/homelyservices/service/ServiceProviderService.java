package com.homely.homelyservices.service;

import java.util.List;

import com.homely.homelyservices.model.ServiceProvider;
import com.homely.homelyservices.model.User;
import com.homely.homelyservices.model.booking_1_model;

import jakarta.xml.ws.Service;

public interface ServiceProviderService {
	
	public List<ServiceProvider> getAllServiceProvider();
	
	public ServiceProvider getServiceProviderById(Integer id);
	
	public ServiceProvider createServiceProvider(ServiceProvider serviceProvider);
	
	public ServiceProvider updateServiceProvider(Integer id,ServiceProvider serviceProvider);
	
	public String deleteServiceProvider(Integer id);

	public List<ServiceProvider> findBySpecialization(String specialization);
	
	public List<booking_1_model> getAllbooking();
	public String upadte_booking();
    public  ServiceProvider findServiceProvider(ServiceProvider serviceProvider);
	 
	public ServiceProvider findEmail(ServiceProvider serviceProvider);
	

	public List<ServiceProvider> getByServiceProviderName(String name);

        
	
}