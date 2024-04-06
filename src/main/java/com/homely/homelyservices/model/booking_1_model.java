package com.homely.homelyservices.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class booking_1_model {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long booking_id;
	
    private String dateTime;
    private String problemDescription;
    private String userName;
    private String service;
    private int totalPrice;
    private String booking_status;

  

	public String getBooking_status() {
		return booking_status;
	}

	public void setBooking_status(String booking_status) {
		this.booking_status = booking_status;
	}

	// Getters and setters
    public Long getId() {
        return booking_id;
    }

    public void setId(Long id) {
        this.booking_id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public booking_1_model(Long booking_id, String dateTime, String problemDescription, String userName, String service,
			int totalPrice, String booking_status) {
		super();
		this.booking_id = booking_id;
		this.dateTime = dateTime;
		this.problemDescription = problemDescription;
		this.userName = userName;
		this.service = service;
		this.totalPrice = totalPrice;
		this.booking_status = booking_status;
	}

	public booking_1_model() {
		super();
	}

	public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
	public String toString() {
		return "booking_1_model [booking_id=" + booking_id + ", dateTime=" + dateTime + ", problemDescription="
				+ problemDescription + ", userName=" + userName + ", service=" + service + ", totalPrice=" + totalPrice
				+ ", booking_status=" + booking_status + "]";
	}
		

}
