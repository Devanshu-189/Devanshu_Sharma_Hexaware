package com.hexaware.cms.Task4;

import java.util.Scanner;

/*
 * 10. Customer Data Validation: Write a function which takes 2 parameters, data-denotes the data and
detail-denotes if it is name addtress or phone number.Validate customer information based on
following critirea. Ensure that names contain only letters and are properly capitalized, addresses do not
contain special characters, and phone numbers follow a specific format (e.g., ###-###-####).
 */

public class CustomerDataValidation {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter address: ");
        String address = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();

        if (validateName(name) && validateAddress(address) && validatePhoneNumber(phone)) {
            System.out.println("Customer data is valid.");
        } else {
            System.out.println("Customer data is invalid.");
        }

        scanner.close();
    }

    static boolean validateName(String name) {
        return name.matches("[A-Z][a-zA-Z]*");
    }

    static boolean validateAddress(String address) {
        return !address.matches(".*[!@#$%^&*()_+=-].*");
    }

    static boolean validatePhoneNumber(String phone) {
        return phone.matches("\\d{3}-\\d{3}-\\d{4}");
    }
}
