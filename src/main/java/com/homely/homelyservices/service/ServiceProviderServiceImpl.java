package com.homely.homelyservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homely.homelyservices.model.ServiceProvider;
import com.homely.homelyservices.model.booking_1_model;
import com.homely.homelyservices.repository.ServiceProviderRepository;
import com.homely.homelyservices.repository.booking_dao;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService{
	
	@Autowired
	private ServiceProviderRepository serviceProviderRepository;

	@Autowired
	private booking_dao booking_dao;
	
	@Override
	public List<ServiceProvider> getAllServiceProvider() {
		// TODO Auto-generated method stub
		return serviceProviderRepository.findAll();
	}

	@Override
	public ServiceProvider getServiceProviderById(Integer id) {
		// TODO Auto-generated method stub
		return serviceProviderRepository.findById(id).get();
	}

	@Override
	public ServiceProvider createServiceProvider(ServiceProvider serviceProvider) {
		// TODO Auto-generated method stub
		return serviceProviderRepository.save(serviceProvider);
	}

	@Override
	public ServiceProvider updateServiceProvider(Integer id, ServiceProvider serviceProvider) {
		// TODO Auto-generated method stub
		ServiceProvider serviceProviderData= serviceProviderRepository.findById(id).get();
		if(serviceProviderData!=null) {
			if(serviceProvider.getName()!=null) {
				serviceProviderData.setName(serviceProvider.getName());
			}
			if(serviceProvider.getEmail()!=null) {
				serviceProviderData.setEmail(serviceProvider.getEmail());
			}
			if(serviceProvider.getMobile()!=null) {
				serviceProviderData.setMobile(serviceProvider.getMobile());
			}
			if(serviceProvider.getSpecialization()!=null) {
				serviceProviderData.setSpecialization(serviceProvider.getSpecialization());
			}
			ServiceProvider updatedServiceProvider=serviceProviderRepository.save(serviceProviderData);
			return updatedServiceProvider;
		}else {
			return null;
		}
	}

	@Override
	public String deleteServiceProvider(Integer id) {
		// TODO Auto-generated method stub
		ServiceProvider serviceProviderData= serviceProviderRepository.findById(id).get();
		if(serviceProviderData!=null) {
			serviceProviderRepository.deleteById(id);
			return "Service Provider has been deleted!";
		}else {
			return "Service Provider not found!";
		}
	}

	@Override
	public List<ServiceProvider> findBySpecialization(String specialization) {
		// TODO Auto-generated method stub
		return serviceProviderRepository.findBySpecialization(specialization);
	}

	@Override
	public List<booking_1_model> getAllbooking() {
	
		return booking_dao.findAll();
	}

	@Override
	public String upadte_booking() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceProvider findServiceProvider(ServiceProvider serviceProvider) {
		// TODO Auto-generated method stub
		
		return serviceProviderRepository.findByEmailAndPassword(serviceProvider.getEmail(), serviceProvider.getPassword());
	}

	@Override
	public ServiceProvider findEmail(ServiceProvider serviceProvider) {
		
		 return serviceProviderRepository.findByEmail(serviceProvider.getEmail());
	}
	


	@Override
	public List<ServiceProvider> getByServiceProviderName(String name) {
		 return serviceProviderRepository.findByName(name);
	}


	
}