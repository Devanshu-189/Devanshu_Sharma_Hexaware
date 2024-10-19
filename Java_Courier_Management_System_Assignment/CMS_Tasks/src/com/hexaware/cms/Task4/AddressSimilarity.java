package com.hexaware.cms.Task4;

/*
 * 15. Find Similar Addresses: Implement a function that finds similar addresses in the system. This can be
useful for identifying duplicate customer entries or optimizing delivery routes.Use string functions to
implement this.
 */

import java.util.Scanner;

public class AddressSimilarity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first address: ");
        String address1 = scanner.nextLine();
        System.out.println("Enter the second address: ");
        String address2 = scanner.nextLine();

        boolean isSimilar = isSimilarAddress(address1, address2);
        if (isSimilar) {
            System.out.println("The addresses are similar.");
        } else {
            System.out.println("The addresses are not similar.");
        }

        scanner.close();
    }

    static boolean isSimilarAddress(String address1, String address2) {
        String address1Lower = address1.toLowerCase();
        String address2Lower = address2.toLowerCase();

        return address1Lower.contains(address2Lower) || address2Lower.contains(address1Lower);
    }
}

