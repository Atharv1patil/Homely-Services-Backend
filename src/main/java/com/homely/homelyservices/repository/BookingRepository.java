package com.homely.homelyservices.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.homely.homelyservices.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer>{
	
	
}
