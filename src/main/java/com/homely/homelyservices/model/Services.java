package com.homely.homelyservices.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Services {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer service_id;
	private String name;
	private Integer category;
	private boolean booked;
	private Integer serviceprovider;
	private Integer unit;
	@Column(columnDefinition = "float")
	private Float price_per_unit;
	public Services() {
		super();
	}
	public Services(Integer service_id, String name, Integer category, boolean booked, Integer serviceprovider,
			Integer unit, Float price_per_unit) {
		super();
		this.service_id = service_id;
		this.name = name;
		this.category = category;
		this.booked = booked;
		this.serviceprovider = serviceprovider;
		this.unit = unit;
		this.price_per_unit = price_per_unit;
	}
	public Integer getService_id() {
		return service_id;
	}
	public void setService_id(Integer service_id) {
		this.service_id = service_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public boolean getBooked() {
		return booked;
	}
	public void setBooked(boolean booked) {
		this.booked = booked;
	}
	
	public Integer getServiceprovider() {
		return serviceprovider;
	}
	public void setServiceprovider(Integer serviceprovider) {
		this.serviceprovider = serviceprovider;
	}
	public Integer getUnit() {
		return unit;
	}
	public void setUnit(Integer unit) {
		this.unit = unit;
	}
	public Float getPrice_per_unit() {
		return price_per_unit;
	}
	public void setPrice_per_unit(Float price_per_unit) {
		this.price_per_unit = price_per_unit;
	}
	
	
	
}
