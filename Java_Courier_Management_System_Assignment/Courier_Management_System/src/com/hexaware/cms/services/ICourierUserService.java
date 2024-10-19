package com.hexaware.cms.services;

import com.hexaware.cms.entities.Courier;
import com.hexaware.cms.exceptions.TrackingNumberNotFoundException;

import java.util.List;

public interface ICourierUserService {
	
	long placeOrder(Courier courierObj);
	
	String getOrderStatus(long trackingNumber) throws TrackingNumberNotFoundException;
	
	boolean cancelOrder(long trackingNumber) throws TrackingNumberNotFoundException;
	
	List<Courier> getAssignedOrder();

}
