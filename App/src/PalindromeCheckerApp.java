/**
 * ================================================================
 * MAIN CLASS - UseCase3PalindromeCheckerApp
 * ================================================================
 *
 * Use Case 3: Reverse String Based Palindrome Check
 *
 * Description:
 * This class checks whether a string is a palindrome
 * by reversing the string and comparing it with
 * the original value.
 *
 * At this stage, the application:
 * - Iterates the string in reverse order
 * - Builds a reversed version
 * - Compares original and reversed strings
 * - Displays the validation result
 *
 * This introduces transformation-based validation.
 *
 * @author Developer
 * @version 3.0
 */

import java.util.Scanner;

public class PalindromeCheckerApp {
    
    // Application Constants
    private static final String APP_NAME = "Palindrome Checker App";
    private static final String APP_VERSION = "3.0";
    
    /**
     * Application entry point for UC3.
     *
     * This is the first method executed by the JVM
     * when the program starts.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Execute Test Case 3: Reverse String Based Palindrome Check
        testCase3();
    }
    
    /**
     * Test Case 3: Reverse String Based Palindrome Check
     * 
     * Tests palindrome validation by reversing the string
     * using a loop and comparing with the original.
     */
    public static void testCase3() {
        // Hardcoded string literal to be checked
        String originalString = "racecar";
        
        // Reverse the string using a loop
        String reversedString = reverseStringUsingLoop(originalString);
        
        // Compare original and reversed strings using equals()
        boolean isPalindrome = originalString.equals(reversedString);
        
        // Display the validation result
        System.out.println("========================================");
        System.out.println("  Use Case 3: Reverse String Check");
        System.out.println("========================================");
        System.out.println("\nOriginal String:  \"" + originalString + "\"");
        System.out.println("Reversed String:  \"" + reversedString + "\"");
        
        if (isPalindrome) {
            System.out.println("\nResult: ✓ IS a palindrome");
        } else {
            System.out.println("\nResult: ✗ NOT a palindrome");
        }
        System.out.println();
    }
    
    /**
     * Reverses a string using a for loop.
     *
     * This method demonstrates:
     * - Loop iteration through string characters
     * - String concatenation using + operator
     * - String immutability (each concatenation creates a new object)
     *
     * @param str the string to reverse
     * @return the reversed string
     */
    public static String reverseStringUsingLoop(String str) {
        // Initialize an empty string to build the reversed version
        String reversed = "";
        
        // Iterate through the string in reverse order using a for loop
        for (int i = str.length() - 1; i >= 0; i--) {
            // Concatenate characters from end to start
            // Note: String concatenation creates a new String object each time
            // due to String immutability in Java
            reversed = reversed + str.charAt(i);
        }
        
        return reversed;
    }
    
    /**
     * Checks if a string is a palindrome.
     *
     * This method:
     * - Removes non-alphanumeric characters
     * - Converts to lowercase
     * - Compares characters from both ends
     *
     * @param str the string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String str) {
        // Remove special characters and convert to lowercase
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        // Reverse the string
        String reversed = new StringBuilder(cleaned).reverse().toString();
        
        // Compare original and reversed
        return cleaned.equals(reversed);
    }
}
