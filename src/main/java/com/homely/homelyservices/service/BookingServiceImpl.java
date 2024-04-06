package com.homely.homelyservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homely.homelyservices.model.Booking;
import com.homely.homelyservices.model.BookingResponse;
import com.homely.homelyservices.model.ServiceProvider;
import com.homely.homelyservices.model.Services;
import com.homely.homelyservices.repository.BookingRepository;
import com.homely.homelyservices.repository.ServiceProviderRepository;
import com.homely.homelyservices.repository.ServicesRepository;

@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private ServicesRepository servicesRepository;
	
	@Autowired
	private ServiceProviderRepository serviceProviderRepository;

	@Override
	public List<Booking> getAllBookings() {
		// TODO Auto-generated method stub
		return bookingRepository.findAll();
	}

	@Override
	public Booking getBookingById(Integer id) {
		// TODO Auto-generated method stub
		return bookingRepository.findById(id).get();
	}

	@Override
	public Booking confirmBooking(Integer id) {
		// TODO Auto-generated method stub
		Booking bookingData=bookingRepository.findById(id).get();
		return bookingRepository.save(bookingData);
	}

	@Override
	public Booking createBooking(BookingResponse body) {
		// TODO Auto-generated method stub
		Services serviceInstance = servicesRepository.findById(body.getServiceId()).get();
		ServiceProvider serviceProviderInstance = serviceProviderRepository.findById(body.serviceProviderId()).get();
		Booking booking=new Booking(null,serviceProviderInstance,serviceInstance,null,null,null);
		return bookingRepository.save(booking);
	}

	@Override
	public Booking updateBooking(Integer id, Booking booking) {
		// TODO Auto-generated method stub
		Booking bookingData=bookingRepository.findById(id).get();
		if(bookingData!=null) {
			if(booking.getUser()!=null) 
				bookingData.setUser(booking.getUser());
			if(booking.getServices()!=null) 
				bookingData.setServices(booking.getServices());
			if(booking.getProblemDescription()!=null) 
				bookingData.setProblemDescription(booking.getProblemDescription());
			if(booking.getServiceProvider()!=null) 
				bookingData.setServiceProvider(booking.getServiceProvider());
			if(booking.getDateTime()!=null) 
				bookingData.setDateTime(booking.getDateTime());
			if(booking.getStatus()!=null) 
				bookingData.setStatus(booking.getStatus());
			return bookingRepository.save(bookingData);
		}else {
			return null;
		}
	}

	@Override
	public String deleteBooking(Integer id) {
		// TODO Auto-generated method stub
		Booking bookingData=bookingRepository.findById(id).get();
		if(bookingData!=null) {
			bookingRepository.delete(bookingData);
			return "booking deleted successfully!";
		}else {
			return "booking not found!";
		}
	}

	
	
	
}
