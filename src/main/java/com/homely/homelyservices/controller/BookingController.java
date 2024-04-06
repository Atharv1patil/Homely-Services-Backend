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

import com.homely.homelyservices.model.Booking;
import com.homely.homelyservices.model.BookingResponse;
import com.homely.homelyservices.service.BookingService;


@CrossOrigin ("*")
@RequestMapping("/api")
@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/bookingapp")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
	@GetMapping("/booking/{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable Integer id){
		return new ResponseEntity<>(bookingService.getBookingById(id),HttpStatus.OK);
	}

    @PostMapping("/confirm/{id}")
    public ResponseEntity<Booking> confirmBooking(@PathVariable("id") Integer id) {
    	return new ResponseEntity<>(bookingService.confirmBooking(id),HttpStatus.OK);
    };

    @PostMapping("/booking")
    public ResponseEntity<Booking> createBooking(@RequestBody BookingResponse body) {
    	return new ResponseEntity<>(bookingService.createBooking(body),HttpStatus.OK);
    }

    @PutMapping("/booking/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable("id") Integer id, @RequestBody Booking booking) {
      
            return new ResponseEntity<>(bookingService.updateBooking(id,booking), HttpStatus.OK);
    }

    @DeleteMapping("/booking/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(bookingService.deleteBooking(id), HttpStatus.OK);
    }

}
