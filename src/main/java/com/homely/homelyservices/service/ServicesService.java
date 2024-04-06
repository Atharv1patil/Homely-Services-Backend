package com.homely.homelyservices.service;

import java.util.List;

import com.homely.homelyservices.model.Services;

public interface ServicesService {
	public List<Services> getAllServices();
	
	public Services getService(Integer id);
	
	public List<Services> getServiceByCategory(Integer cid);
	
	public Services addService(Services services);
	
	public Services updateService(Integer id,Services services);
	
	public String deleteService(Integer id);

	

	

	
	
}
