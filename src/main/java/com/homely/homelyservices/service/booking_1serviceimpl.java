package com.homely.homelyservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.homely.homelyservices.model.booking_1_model;
import com.homely.homelyservices.repository.booking_dao;

@Service
public class booking_1serviceimpl implements booking_1service {
	
	@Autowired
	private booking_dao bokkDao;

	@Override
	public List<booking_1_model> addServices(@RequestBody List<booking_1_model> bookings) {
		
		return bokkDao.saveAll(bookings);
	}

	@Override
	public List<booking_1_model> getAllbookings() {
		
		return bokkDao.findAll();
	}

	@Override
	public booking_1_model updateBookingStatus(Long booking_id, String booking_status) {
		booking_1_model booking = bokkDao.findById(booking_id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + booking_id));

        booking.setBooking_status(booking_status);
        return bokkDao.save(booking);

		
	}

	@Override
	public List<booking_1_model> getBookingsByName(String userName) {
		
		return  bokkDao.findByuserName(userName);
	}
	

	


	
	
}


