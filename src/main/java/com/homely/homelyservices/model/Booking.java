package com.homely.homelyservices.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer booking_id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "serviceprovider_id")
    private ServiceProvider serviceProvider;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private Services services;
    @Column(length=500)
    private String problemDescription;
    
    private String dateTime;
    private String status;
	public Booking() {
		super();
	}
	public Booking(  User user, ServiceProvider serviceProvider,
			Services services, String problemDescription, String dateTime, String status) {
		super();
		
		
		this.user = user;
		this.serviceProvider = serviceProvider;
		this.services = services;
		this.problemDescription = problemDescription;
		this.dateTime = dateTime;
		this.status = status;
	}
	public Integer getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(Integer booking_id) {
		this.booking_id = booking_id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	public Services getServices() {
		return services;
	}
	public void setServices(Services services) {
		this.services = services;
	}
	public String getProblemDescription() {
		return problemDescription;
	}
	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
    
    
}
