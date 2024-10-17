package com.hexaware.cms.Task2;

/*
 * 6. Implement a while loop to track the real-time location of a courier until it reaches its destination.
 */

import java.util.Random;

public class CourierTracking {
    public static void main(String[] args) {
        Random random = new Random();
        int destination = 10; // Assume destination is 10km away
        int currentLocation = 0;

        while (currentLocation < destination) {
            currentLocation += random.nextInt(3); // Random movement between 0 to 2km
            System.out.println("Current location: " + currentLocation + " km");
        }

        System.out.println("Courier has reached the destination.");
    }
}
