package com.homely.homelyservices.service;

import java.util.List;


import org.springframework.web.bind.annotation.RequestBody;


import com.homely.homelyservices.model.booking_1_model;

public interface booking_1service {
	
	public List<booking_1_model> addServices(@RequestBody List<booking_1_model> bookings);
    public List<booking_1_model> getAllbookings();
//    public booking_1_model updateBookingStatus(Long booking_id, String booking_status);
//	public booking_1_model updateBookingStatus(Long booking_id, booking_1_model booking_1_model1);
//	public booking_1_model updateBookingStatus1(Long booking_id, String booking_status);
    public booking_1_model updateBookingStatus(Long booking_id, String booking_status);
    public List<booking_1_model> getBookingsByName(String userName);
        
}
