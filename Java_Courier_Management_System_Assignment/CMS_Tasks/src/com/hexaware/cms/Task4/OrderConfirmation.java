package com.hexaware.cms.Task4;

/*
 * 12. Order Confirmation Email: Create a program that generates an order confirmation email. The email
should include details such as the customer's name, order number, delivery address, and expected
delivery date.
 */

public class OrderConfirmation {
	
    public static void main(String[] args) {
        String customerName = "Rahul Sharma";
        String orderNumber = "ORD123456";
        String deliveryAddress = "456, MG Road, Bengaluru, Karnataka, 560001";
        String deliveryDate = "2024-10-20";

        String email = generateOrderConfirmation(customerName, orderNumber, deliveryAddress, deliveryDate);
        System.out.println(email);
    }

    static String generateOrderConfirmation(String name, String orderNo, String address, String date) {
        return "Dear " + name + ",\n" +
               "Thank you for your order! Your order number is " + orderNo + ".\n" +
               "Delivery Address: " + address + "\n" +
               "Expected Delivery Date: " + date + "\n" +
               "Thank you for shopping with us!";
    }
}
