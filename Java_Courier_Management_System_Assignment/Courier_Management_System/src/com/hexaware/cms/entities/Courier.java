package com.hexaware.cms.entities;

import java.util.Date;

public class Courier {
	
	private int courierID;
	private String senderName;
	private String senderAddress;
	private String receiverName;
	private String receiverAddress;
	private int weight;
	private String status;
	private long trackingNumber; 
    private Date deliveryDate;

    private static long trackingNumberValue = 1000;

    // Default constructor
    public Courier() {
        this.trackingNumber = ++trackingNumberValue; // Auto-incrementing tracking number
    }

    public Courier(int courierID, String senderName, String senderAddress, String receiverName, String receiverAddress, int weight, String status, long trackingNumber, Date deliveryDate) {
        this(); 
        this.courierID = courierID;
        this.senderName = senderName;
        this.senderAddress = senderAddress;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.weight = (int)weight;
        this.status = status;
        this.trackingNumber = trackingNumber; 
        this.deliveryDate = deliveryDate;
    }

	public int getCourierID() {
		return courierID;
	}

	public void setCourierID(int courierID) {
		this.courierID = courierID;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(long trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	public String toString() {
	    return "Courier{" +
	            "courierID=" + courierID +
	            ", senderName='" + senderName + '\'' +
	            ", senderAddress='" + senderAddress + '\'' +
	            ", receiverName='" + receiverName + '\'' +
	            ", receiverAddress='" + receiverAddress + '\'' +
	            ", weight=" + weight +
	            ", status='" + status + '\'' +
	            ", trackingNumber=" + trackingNumber +
	            ", deliveryDate='" + deliveryDate + '\'' +
	            '}';
	}
	
	
	

}
