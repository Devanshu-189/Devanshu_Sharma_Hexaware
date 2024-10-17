package com.hexaware.cms.entities;

import java.util.ArrayList;
import java.util.List;

public class CourierCompanyCollection {
	
	private String companyName;
	private List<Courier> courierDetails = new ArrayList<>();
	private List<Employee> employeeDetails = new ArrayList<>();
	private List<Location> locationDetails = new ArrayList<>();
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public List<Courier> getCourierDetails() {
		return courierDetails;
	}
	public void setCourierDetails(List<Courier> courierDetails) {
		this.courierDetails = courierDetails;
	}
	
	public List<Employee> getEmployeeDetails() {
		return employeeDetails;
	}
	public void setEmployeeDetails(List<Employee> employeeDetails) {
		this.employeeDetails = employeeDetails;
	}
	
	public List<Location> getLocationDetails() {
		return locationDetails;
	}
	public void setLocationDetails(List<Location> locationDetails) {
		this.locationDetails = locationDetails;
	}

}
