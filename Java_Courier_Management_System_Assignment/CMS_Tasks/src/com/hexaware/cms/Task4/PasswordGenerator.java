package com.hexaware.cms.Task4;

/*
 * 14. Password Generator: Create a function that generates secure passwords for courier system
accounts. Ensure the passwords contain a mix of uppercase letters, lowercase letters, numbers, and
special characters.
 */

import java.util.Scanner;

public class PasswordGenerator {
	
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	System.out.print("Enter the length (4 or above) of required password: ");
        int length = s.nextInt(); 
        String password = generatePassword(length);
        System.out.println("Generated Password: " + password);
    }

    static String generatePassword(int length) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String special = "!@#$%^&*()-_=+";
        String combined = upper + lower + digits + special;

        StringBuilder password = new StringBuilder();

        password.append(upper.charAt((int) (Math.random() * upper.length())));
        password.append(lower.charAt((int) (Math.random() * lower.length())));
        password.append(digits.charAt((int) (Math.random() * digits.length())));
        password.append(special.charAt((int) (Math.random() * special.length())));

        for (int i = 4; i < length; i++) {
            password.append(combined.charAt((int) (Math.random() * combined.length())));
        }

        return password.toString();
    }
}

