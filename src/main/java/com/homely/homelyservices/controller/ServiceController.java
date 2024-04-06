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
import org.springframework.web.bind.annotation.RestController;

import com.homely.homelyservices.model.Services;
import com.homely.homelyservices.service.ServicesService;


@CrossOrigin ("*")
@RestController
@RequestMapping("/api")
public class ServiceController {
	
	@Autowired
	private ServicesService servicesService;

	@GetMapping("/service")
	public ResponseEntity<List<Services>> getAllServices(){
		
		return new ResponseEntity<>(servicesService.getAllServices(),HttpStatus.OK);
	}

	@GetMapping("/service/{sid}")
	public ResponseEntity<Services> getService(@PathVariable("sid") Integer sid) {
		return new ResponseEntity<>(servicesService.getService(sid),HttpStatus.OK);
	}

	@GetMapping("/service/byCategory/{cid}")
	public List<Services> getServiceByCategory(@PathVariable("cid") Integer cid) {
		return this.servicesService.getServiceByCategory(cid);
	}


	@PostMapping("/service")
	public ResponseEntity<Services> addService(@RequestBody Services services) {
		return new ResponseEntity<>(servicesService.addService(services),HttpStatus.CREATED);
	}

	@PutMapping("/service/{id}")
	public ResponseEntity<Services> updateService(@PathVariable("id") Integer id, @RequestBody Services services) {
		
			return new ResponseEntity<>(servicesService.updateService(id,services), HttpStatus.OK);
		
	}

	@DeleteMapping("/service/{id}")
	public ResponseEntity<String> deleteService(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(servicesService.deleteService(id), HttpStatus.OK);
	}
}
