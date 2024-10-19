package com.hexaware.cms.Task4;

/*
 * 9. Parcel Tracking: Create a program that allows users to input a parcel tracking number.Store the
tracking number and Status in 2d String Array. Initialize the array with values. Then, simulate the
tracking process by displaying messages like "Parcel in transit," "Parcel out for delivery," or "Parcel
delivered" based on the tracking number's status.
 */

import java.util.Scanner;

public class ParcelTracking {
    public static void main(String[] args) {
        String[][] parcels = {
            {"123456", "In Transit"},
            {"234567", "Out for Delivery"},
            {"345678", "Delivered"}
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter tracking number: ");
        String trackingNumber = scanner.nextLine();

        for (String[] parcel : parcels) {
            if (parcel[0].equals(trackingNumber)) {
                System.out.println("Parcel Status: " + parcel[1]);
                break;
            }
        }

        scanner.close();
    }
}
