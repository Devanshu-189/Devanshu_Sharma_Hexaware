package com.hexaware.cms.Task1;

import java.util.Scanner;

/* 
 * 1. Write a program that checks whether a given order is delivered or not based on its status (e.g.,
"Processing," "Delivered," "Cancelled"). Use if-else statements for this
 */

public class OrderDelivery {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter order status (Processing, Delivered, Cancelled): ");
        String status = scanner.nextLine();

        if (status.equals("Delivered")) {
            System.out.println("The order has been delivered.");
        } else if (status.equals("Processing")) {
            System.out.println("The order is still being processed.");
        } else if (status.equals("Cancelled")) {
            System.out.println("The order has been cancelled.");
        } else {
            System.out.println("Invalid status.");
        }

        scanner.close();
	}

}
