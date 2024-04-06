package com.homely.homelyservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homely.homelyservices.model.Services;
import com.homely.homelyservices.repository.ServicesRepository;

@Service
public class ServicesServiceImpl implements ServicesService{
	
	@Autowired
	private ServicesRepository servicesRepository;

	@Override
	public List<Services> getAllServices() {
		// TODO Auto-generated method stub
		return this.servicesRepository.findAll();
	}

	@Override
	public Services getService(Integer id) {
		// TODO Auto-generated method stub
		return servicesRepository.findById(id).get();
	}

	@Override
	public List<Services> getServiceByCategory(Integer cid) {
		// TODO Auto-generated method stub
		return servicesRepository.findServicesByCategory(cid);
	}

	@Override
	public Services addService(Services services) {
		// TODO Auto-generated method stub
		return servicesRepository.save(services);
	}

	@Override
	public Services updateService(Integer id, Services services) {
		// TODO Auto-generated method stub
		Services serviceData = servicesRepository.findById(id).get();
		if (serviceData!=null) {
			System.out.println(services);
			if (services.getName() != null) serviceData.setName(services.getName());
			if (services.getCategory() != 0) serviceData.setCategory(services.getCategory());
			if (services.getServiceprovider() != 0) serviceData.setServiceprovider(services.getServiceprovider());
			if (services.getPrice_per_unit() != 0) serviceData.setPrice_per_unit(services.getPrice_per_unit());
			if (services.getUnit() != 0) serviceData.setUnit(services.getUnit());
			if (services.getBooked() !=false) serviceData.setBooked(services.getBooked());


			Services updatedService = servicesRepository.save(serviceData);
			return updatedService;
		} else {
			return null;
		}
	}

	@Override
	public String deleteService(Integer id) {
		// TODO Auto-generated method stub
		Services services=servicesRepository.findById(id).get();
		
		if(services!=null) {
			servicesRepository.delete(services);
			return "Service deleted succesfully";
		}else {
			return "Service not found";
		}
	}

	
}
