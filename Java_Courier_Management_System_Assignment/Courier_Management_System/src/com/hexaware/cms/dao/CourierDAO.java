package com.hexaware.cms.dao;

import com.hexaware.cms.entities.Courier;
import com.hexaware.cms.exceptions.InvalidEmployeeIdException;
import com.hexaware.cms.exceptions.TrackingNumberNotFoundException;
import com.hexaware.cms.util.DBConnUtil;
import java.util.Scanner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class CourierDAO {
	
	private Connection connection;
	
	Scanner scanner = new Scanner(System.in);
	
	private static final String INSERT_COURIER_SQL = "INSERT INTO COURIER (CourierID, SenderName, SenderAddress, ReceiverName, ReceiverAddress, Weight, Status, TrackingNumber, DeliveryDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SELECT_COURIER_BY_TRACKING = "SELECT * FROM Courier WHERE TrackingNumber = ?";
	private static final String UPDATE_COURIER_STATUS = "UPDATE Courier SET Status= ? WHERE TrackingNumber= ?";
	private static final String SELECT_EMPLOYEE = "SELECT * FROM EMPLOYEE WHERE EmployeeID=?";
	
	public CourierDAO() {
		try {
			this.connection = DBConnUtil.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	 public void deleteCourier(int courierID) {
	        String sql = "DELETE FROM courier WHERE courierID = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setInt(1, courierID);
	            preparedStatement.executeUpdate();
	            System.out.println("Courier deleted successfully!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
	
	public void showCourierByTracking(int trackingNumber) throws SQLException{
		try {
			PreparedStatement statement = connection.prepareStatement(SELECT_COURIER_BY_TRACKING);
			statement.setLong(1, trackingNumber);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String senderName = rs.getString("senderName");
				String senderAddress = rs.getString("senderAddress");
				String receiverName = rs.getString("receiverName");
				String receiverAddress = rs.getString("receiverAddress");
				String deliveryStatus = rs.getString("status");
				System.out.println("Sender's Name: "+senderName+", Sender's Address: "+senderAddress+", Receiver's Name: "+receiverName+", Receiver's Address: "+receiverAddress+", Delivery Status: "+deliveryStatus);
			}
		}catch (SQLException e) {
			System.err.println("Error unable to fetch records: " + e.getMessage());
	        throw e;
		}
	}
	
	public void getEmployee(int empID) throws SQLException, InvalidEmployeeIdException {
		boolean employeeFound = false;
		try {
			
			PreparedStatement statement = connection.prepareStatement(SELECT_EMPLOYEE);
			statement.setLong(1, empID);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				employeeFound = true;
				int employeeID = rs.getInt("EmployeeID");
				String empName = rs.getString("Name");
				String empEmail = rs.getString("Email");
				String empContact = rs.getString("ContactNumber");
				String empRole = rs.getString("Role");
				Double empSalary = rs.getDouble("Salary");
				System.out.println("Employee ID: "+employeeID+", Employee's Name: "+empName+", Employee's Email: "+empEmail+", Employee's contact: "+empContact+", Employee's Role: "+empRole+", Employee's Salary: "+empSalary);
			}
			if (!employeeFound) {
                throw new InvalidEmployeeIdException("Employee ID not found: " + empID);
            }
		} catch(SQLException e) {
			System.err.println("Error unable to fetch records: " + e.getMessage());
	        throw e;
		}
	}
	
	
	public void updateCourierStatus(long trackingNumber) throws SQLException {
		System.out.println("Enter the value for changing the status of courier to : ");
		Scanner sc = new Scanner(System.in);
		System.out.println("1: Delivered");
		System.out.println("2: In-Transit");
		System.out.println("3: Yet-to-Transit");
		System.out.print("Waiting for value to be entered: ");
		int value = sc.nextInt();
		String newCourierStatus = "";
		switch(value) {
		case 1:
			newCourierStatus = "Delivered";
			break;
		case 2:
			newCourierStatus = "In-Transit";
			break;
		case 3:
			newCourierStatus = "Yet-to-Transit";
			break;
		default:
			System.out.println("Not a valid value !");
			break;
		}
		
		try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COURIER_STATUS)){
			preparedStatement.setString(1, newCourierStatus);
			preparedStatement.setLong(2, trackingNumber);
			preparedStatement.executeUpdate();
			System.out.println("Status Updated Successfully.");
		} catch (SQLException e) {
			System.err.println("Error updating courier status: " + e.getMessage());
	        throw e;
		}
	}
	
	public List<Courier> getAllCouriers() {
        List<Courier> couriers = new ArrayList<>();
        String sql = "SELECT * FROM couriers";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

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

                couriers.add(courier);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return couriers;
    }

	
	public void insertCourier() throws SQLException {
        System.out.print("Enter Sender Name: ");
        String senderName = scanner.nextLine();
        System.out.print("Enter Sender Address: ");
        String senderAddress = scanner.nextLine();
        System.out.print("Enter Receiver Name: ");
        String receiverName = scanner.nextLine();
        System.out.print("Enter Receiver Address: ");
        String receiverAddress = scanner.nextLine();
        System.out.print("Enter Weight (in kg): ");
        int weight = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Status: ");
        String status = scanner.nextLine();
        System.out.print("Enter Tracking Number: ");
        long trackingNumber = scanner.nextLong();
        Date deliveryDate = new Date();
        Courier courier = new Courier(senderAddress, receiverName, receiverAddress, weight, status, trackingNumber, deliveryDate, senderName);
		try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COURIER_SQL)) {
			preparedStatement.setInt(1, courier.getCourierID());
			preparedStatement.setString(2, courier.getSenderName());
			preparedStatement.setString(3, courier.getSenderAddress());
			preparedStatement.setString(4, courier.getReceiverName());
            preparedStatement.setString(5, courier.getReceiverAddress());
            preparedStatement.setDouble(6, courier.getWeight());
            preparedStatement.setString(7, courier.getStatus());
            preparedStatement.setLong(8, courier.getTrackingNumber());
            preparedStatement.setDate(9, new java.sql.Date(courier.getDeliveryDate().getTime()));
            preparedStatement.executeUpdate();
            System.out.print("Courier Inserted Successfully.");
		} catch (SQLException e) {
			System.err.println("Error inserting courier: " + e.getMessage());
	        throw e;
		}
	}

}
 