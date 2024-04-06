package com.homely.homelyservices.service;

import java.util.List;

import com.homely.homelyservices.model.Booking;
import com.homely.homelyservices.model.BookingResponse;

public interface BookingService {
	public List<Booking> getAllBookings();
	
	public Booking getBookingById(Integer id);
	
	public Booking confirmBooking(Integer id);
	
	public Booking createBooking(BookingResponse body);
	
	public Booking updateBooking(Integer id,Booking booking);
	
	public String deleteBooking(Integer id);

}
