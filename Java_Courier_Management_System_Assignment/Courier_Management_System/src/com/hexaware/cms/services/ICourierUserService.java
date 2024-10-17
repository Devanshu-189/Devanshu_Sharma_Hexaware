package com.hexaware.cms.services;

import com.hexaware.cms.entities.Courier;
import java.util.List;

public interface ICourierUserService {
	
	long placeOrder(Courier courierObj);
	
	String getOrderStatus(long trackingNumber);
	
	boolean cancelOrder(long trackingNumber);
	
	List<Courier> getAssignedOrder();

}
