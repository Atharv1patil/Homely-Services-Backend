package com.homely.homelyservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.homely.homelyservices.model.booking_1_model;

public interface booking_dao extends JpaRepository<booking_1_model, Long> {

//	 List<booking_1_model> findByBookingStatus(String booking_status);
	 List<booking_1_model> findByuserName(String userName);
}
