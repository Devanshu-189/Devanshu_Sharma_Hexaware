package com.hexaware.cms.Task1;

import java.util.Scanner;

/*
 * 2. Implement a switch-case statement to categorize parcels based on their weight into "Light,"
"Medium," or "Heavy."

 */

public class ParcelWeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter parcel weight in kg: ");
        double weight = scanner.nextDouble();

        String category;

        if (weight < 0) {
            category = "Invalid weight";
        } else if (weight >= 0 && weight <= 5) {
            category = "Light";
        } else if (weight > 5 && weight <= 15) {
            category = "Medium";
        } else if (weight > 15 && weight <= 30) {
            category = "Heavy";
        } else {
            category = "Very Heavy";
        }

        System.out.println("The parcel is categorized as: " + category);
        scanner.close();
    }
}
