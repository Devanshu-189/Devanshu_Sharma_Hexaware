package com.hexaware.cms.Task3;

/*
 * 
7. Create an array to store the tracking history of a parcel, where each entry represents a location
update.
 */

public class ParcelTrackingHistory {
	
    public static void main(String[] args) {
        String[][] trackingHistory = {
            {"Location A", "In Transit"},
            {"Location B", "Out for Delivery"},
            {"Location C", "Delivered"}
        };

        System.out.println("Parcel Tracking History:");
        for (String[] update : trackingHistory) {
            System.out.println("At " + update[0] + ": " + update[1]);
        }
    }
}

