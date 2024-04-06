package com.homely.homelyservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.homely.homelyservices.model.booking_1_model;
import com.homely.homelyservices.service.booking_1service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin ("*")
@RestController
public class Booking_controller1 {
	
	@Autowired
	private booking_1service booking_1Service;
	
 @GetMapping("/home")
public String working_1() {
return "The method is working";
}
 
 @GetMapping("/getbooking")
 public List<booking_1_model> getAllbookings() {
     return  booking_1Service.getAllbookings();
 }
 
 @GetMapping("/bookings/{userName}")
 public List<booking_1_model> getBookingsByName(@PathVariable String userName) {
     return booking_1Service.getBookingsByName(userName);
 }
 
 
 
 
@PostMapping("/addservices")
public List<booking_1_model> addServices(@RequestBody List<booking_1_model> bookings) {
	return booking_1Service.addServices(bookings);
    
}
@PutMapping("/{booking_id}/status")
public booking_1_model updateBookingStatus(@PathVariable("booking_id") Long booking_id, @RequestParam String booking_status) {
    return booking_1Service.updateBookingStatus(booking_id, booking_status);
}


}
