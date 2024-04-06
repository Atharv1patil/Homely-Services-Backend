package com.homely.homelyservices.model;

public class BookingResponse {
	private String customerEmail;
	private Integer serviceProviderId;
	private Integer serviceId;
	public BookingResponse() {
		super();
	}
	public BookingResponse(String customerEmail, Integer serviceProviderId, Integer serviceId) {
		super();
		this.customerEmail = customerEmail;
		this.serviceProviderId = serviceProviderId;
		this.serviceId = serviceId;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public Integer serviceProviderId() {
		return serviceProviderId;
	}
	public void setserviceProviderId(Integer serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	
	
}
