package com.hexaware.cms.Task2;

/*
 * 5. Write a Java program that uses a for loop to display all the orders for a specific customer.
 */

import java.util.Scanner;

public class DisplayOrders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] orders = {"Order 1", "Order 2", "Order 3", "Order 4"};

        System.out.println("Displaying orders for the customer:");
        for (String order : orders) {
            System.out.println(order);
        }

        scanner.close();
    }
}
