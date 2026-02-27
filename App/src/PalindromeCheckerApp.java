/**
 * ================================================================
 * MAIN CLASS - UseCase2PalindromeCheckerApp
 * ================================================================
 *
 * Use Case 2: Hardcoded Palindrome Validation
 *
 * Description:
 * This class demonstrates basic palindrome validation
 * using a hardcoded string value.
 *
 * At this stage, the application:
 * - Stores a predefined string
 * - Compares characters from both ends
 * - Determines whether the string is a palindrome
 * - Displays the result on the console
 *
 * This use case introduces fundamental comparison logic
 * before using advanced data structures.
 *
 * @author Developer
 * @version 2.0
 */

import java.util.Scanner;

public class PalindromeCheckerApp {
    
    // Application Constants
    private static final String APP_NAME = "Palindrome Checker App";
    private static final String APP_VERSION = "2.0";
    
    /**
     * Application entry point for UC2.
     *
     * This is the first method executed by the JVM
     * when the program starts.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Execute Test Case 2: Hardcoded Palindrome Validation
        testCase2();
    }
    
    /**
     * Test Case 2: Hardcoded Palindrome Validation
     * 
     * Tests palindrome validation using a hardcoded string.
     * Demonstrates basic string comparison logic.
     */
    public static void testCase2() {
        // Hardcoded string literal to be checked
        String hardcodedString = "madam";
        
        // Check if the string is a palindrome
        boolean result = isPalindrome(hardcodedString);
        
        // Display the result on the console
        System.out.println("========================================");
        System.out.println("  Use Case 2: Hardcoded Palindrome");
        System.out.println("========================================");
        System.out.println("\nString to check: \"" + hardcodedString + "\"");
        
        if (result) {
            System.out.println("Result: ✓ IS a palindrome");
        } else {
            System.out.println("Result: ✗ NOT a palindrome");
        }
        System.out.println();
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

}
