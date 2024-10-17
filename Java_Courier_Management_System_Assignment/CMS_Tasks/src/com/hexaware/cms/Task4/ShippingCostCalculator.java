package com.hexaware.cms.Task4;

/*
 * 13. Calculate Shipping Costs: Develop a function that calculates the shipping cost based on the distance
between two locations and the weight of the parcel. You can use string inputs for the source and
destination addresses.
 */

import java.util.Scanner;

public class ShippingCostCalculator {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter source address: ");
        String source = scanner.nextLine();
        System.out.println("Enter destination address: ");
        String destination = scanner.nextLine();
        System.out.println("Enter distance in km: ");
        double distance = scanner.nextDouble();
        System.out.println("Enter weight of the parcel in kg: ");
        double weight = scanner.nextDouble();

        double shippingCost = calculateShippingCost(distance, weight);
        System.out.printf("Shipping cost from %s to %s is: ₹%.2f%n", source, destination, shippingCost);

        scanner.close();
    }

    static double calculateShippingCost(double distance, double weight) {
        double costPerKg = 10.0; 
        double costPerKm = 5.0; 
        return (costPerKg * weight) + (costPerKm * distance);
    }
}
