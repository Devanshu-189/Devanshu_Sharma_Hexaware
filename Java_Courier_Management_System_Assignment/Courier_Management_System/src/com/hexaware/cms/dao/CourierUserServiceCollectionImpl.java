package com.hexaware.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.cms.entities.Courier;
import com.hexaware.cms.entities.CourierCompanyCollection;
import com.hexaware.cms.exceptions.TrackingNumberNotFoundException;
import com.hexaware.cms.services.ICourierUserService;
import com.hexaware.cms.util.DBConnUtil;

public class CourierUserServiceCollectionImpl implements ICourierUserService {
	
	private Connection connection;
	
	public CourierUserServiceCollectionImpl() throws SQLException {
		connection = DBConnUtil.getConnection();
	}
	
	@Override
	public long placeOrder(Courier courierObj) {
	    String sql = "INSERT INTO courier (courierID, senderName, senderAddress, receiverName, receiverAddress, weight, status, trackingNumber, deliveryDate) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    long trackingNumber = courierObj.getTrackingNumber();
	    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	    	preparedStatement.setInt(1, courierObj.getCourierID());
	        preparedStatement.setString(2, courierObj.getSenderName());
	        preparedStatement.setString(3, courierObj.getSenderAddress());
	        preparedStatement.setString(4, courierObj.getReceiverName());
	        preparedStatement.setString(5, courierObj.getReceiverAddress());
	        preparedStatement.setInt(6, courierObj.getWeight());
	        preparedStatement.setString(7, courierObj.getStatus());
	        preparedStatement.setLong(8, courierObj.getTrackingNumber());
	        preparedStatement.setDate(9, new java.sql.Date(courierObj.getDeliveryDate().getTime()));
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        trackingNumber = -1; 
	    }
	    return trackingNumber; 
	}
	
	
	@Override
    public String getOrderStatus(long trackingNumber) throws TrackingNumberNotFoundException {
        String sql = "SELECT status FROM courier WHERE trackingNumber = ?";
        String status = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, trackingNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                status = resultSet.getString("status");
                System.out.println("Order status : " + status);
            } else {
                throw new TrackingNumberNotFoundException("Tracking number not found: " + trackingNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
	
	@Override
    public boolean cancelOrder(long trackingNumber) throws TrackingNumberNotFoundException {
        String sql = "UPDATE courier SET status = 'Cancelled' WHERE trackingNumber = ?";
        boolean isCancelled = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, trackingNumber);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Order Cancel operation done successfully.");
                isCancelled = true;
            } else {
                throw new TrackingNumberNotFoundException("Tracking number not found: " + trackingNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCancelled;
    }
	
	@Override
	public List<Courier> getAssignedOrder() { 
	    String sql = "SELECT * FROM courier WHERE STATUS = ?";
	    List<Courier> assignedOrders = new ArrayList<>();
	    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	    	preparedStatement.setString(1, "Yet-to-Transit");
	        ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	            Courier courier = new Courier();
	            courier.setCourierID(resultSet.getInt("courierID"));
	            courier.setSenderName(resultSet.getString("senderName"));
	            courier.setSenderAddress(resultSet.getString("senderAddress"));
	            courier.setReceiverName(resultSet.getString("receiverName"));
	            courier.setReceiverAddress(resultSet.getString("receiverAddress"));
	            courier.setWeight(resultSet.getInt("weight"));
	            courier.setStatus(resultSet.getString("status"));
	            courier.setTrackingNumber(resultSet.getLong("trackingNumber"));
	            courier.setDeliveryDate(resultSet.getDate("deliveryDate"));
	            assignedOrders.add(courier);
	        }
	        for (Courier assignedOrder : assignedOrders) {
	            System.out.println(assignedOrder.toString()); 
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return assignedOrders;
	}

	
}
