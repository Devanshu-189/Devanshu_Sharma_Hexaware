package com.hexaware.cms.Task4;

/*
 * 11. Address Formatting: Develop a function that takes an address as input (street, city, state, zip code)
and formats it correctly, including capitalizing the first letter of each word and properly formatting the
zip code.

 */

public class AddressFormatting {
	
    public static void main(String[] args) {
        String formattedAddress = formatAddress("123 main st, some city, some state, 12345");
        System.out.println("Formatted Address: " + formattedAddress);
    }

    static String formatAddress(String address) {
        String[] parts = address.split(", ");
        StringBuilder formatted = new StringBuilder();

        for (String part : parts) {
            String[] words = part.split(" ");
            for (String word : words) {
                formatted.append(Character.toUpperCase(word.charAt(0)))
                         .append(word.substring(1).toLowerCase()).append(" ");
            }
            formatted.append(", ");
        }

        // Remove the last comma and space
        return formatted.substring(0, formatted.length() - 2);
    }
}
