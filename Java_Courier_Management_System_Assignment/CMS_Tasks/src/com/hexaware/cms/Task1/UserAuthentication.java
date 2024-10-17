package com.hexaware.cms.Task1;

import java.util.Scanner;

/*
 * 3. Implement User Authentication 1. Create a login system for employees and customers using Java
control flow statements.
 */

public class UserAuthentication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username, password;

        System.out.println("Enter username: ");
        username = scanner.nextLine();
        System.out.println("Enter password: ");
        password = scanner.nextLine();

        // Valid user credentials
        String validUsername = "admin";
        String validPassword = "root";

        if (username.equals(validUsername) && password.equals(validPassword)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }

        scanner.close();
    }
}
