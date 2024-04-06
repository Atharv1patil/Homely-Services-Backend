package com.homely.homelyservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homely.homelyservices.model.ServiceProvider;
import com.homely.homelyservices.model.User;
import com.homely.homelyservices.repository.ServiceProviderRepository;
//import com.homely.homelyservices.model.User;
import com.homely.homelyservices.service.ServiceProviderService;

import jakarta.xml.ws.Service;
@CrossOrigin ("*")
@RestController
@RequestMapping("/api")
public class ServiceProviderController {
	
	@Autowired
	private ServiceProviderService serviceProviderService;
	
	@Autowired
	private ServiceProviderRepository serviceProviderRepository;
	@GetMapping("/serviceprovider")
	public ResponseEntity<List<ServiceProvider>> getAllServiceProvider(){
		return new ResponseEntity<>(serviceProviderService.getAllServiceProvider(), HttpStatus.OK);
	}
	
	@GetMapping("/serviceprovider/{id}")
	public ResponseEntity<ServiceProvider> getServiceProviderById(Integer id){
		return new ResponseEntity<>(serviceProviderService.getServiceProviderById(id), HttpStatus.OK);
	}
	
	@PostMapping("/registerserviceprovider")
    public ResponseEntity<ServiceProvider> createServiceProvider(@RequestBody ServiceProvider serviceProvider) {
		return new ResponseEntity<>(serviceProviderService.createServiceProvider(serviceProvider), HttpStatus.CREATED);
    }
	
	@PutMapping("/serviceprovider/{id}")
    public ResponseEntity<ServiceProvider> updateServiceProvider(@PathVariable("id") Integer id, @RequestBody ServiceProvider serviceProvider) {
            return new ResponseEntity<>(serviceProviderService.updateServiceProvider(id,serviceProvider), HttpStatus.OK);
       
    }
	
	@DeleteMapping("/serviceprovider/{id}")
    public ResponseEntity<String> deleteServiceProvider(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(serviceProviderService.deleteServiceProvider(id), HttpStatus.OK);
    }
	
	
	 @GetMapping("/serviceprovider/bySpecialization")
	    public ResponseEntity<List<ServiceProvider>> getServiceProvidersBySpecialization(@RequestParam String specialization) {
	        List<ServiceProvider> serviceProviders = serviceProviderService.findBySpecialization(specialization);
	        return ResponseEntity.ok(serviceProviders);
	    }
	 
//	 @PostMapping("/splogin") 
//	 public ServiceProvider findServiceProvider(@RequestBody ServiceProvider serviceProvider) {
//	  
//	ServiceProvider spObj=serviceProviderService.findServiceProvider(serviceProvider);
//	  return spObj;
//	    
//	  }
//	 
//	 @PostMapping("/spcheckEmail") 
//	 public ServiceProvider findEmail(@RequestBody ServiceProvider serviceProvider) {
//	  
//		 ServiceProvider spObj1=serviceProviderService.findEmail(serviceProvider);
//	  return spObj1;
//	    
//	  }
	 
	 @PostMapping("/splogin") 
	 public ServiceProvider findServiceProvider(@RequestBody ServiceProvider serviceProvider) {
	     ServiceProvider spObj = serviceProviderService.findServiceProvider(serviceProvider);
	     return spObj;
	 }

	 @PostMapping("/spcheckEmail") 
	 public ServiceProvider findEmail(@RequestBody ServiceProvider serviceProvider) {
	     ServiceProvider spObj1 = serviceProviderService.findEmail(serviceProvider);
	     return spObj1;
	 }
	 @GetMapping("/email1/{name}")
	    public String getEmailByUsername(@PathVariable String name) {
	        ServiceProvider serviceProvider = serviceProviderRepository.findByname(name);
	            return serviceProvider.getEmail();
		}
	 
	 @GetMapping("/name/{name}")
	    public List<ServiceProvider> getServiceProviderByName(@PathVariable String name) {
	        ServiceProvider serviceProvider = serviceProviderRepository.findByname(name);
	        
	            return serviceProviderRepository.findAll();}
	 
	 @GetMapping("/services/{name}")
     public List<ServiceProvider> getByServiceProviderName(@PathVariable String name) {
         return serviceProviderService.getByServiceProviderName(name);
     }


}