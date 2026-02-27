/**
 * ================================================================
 * MAIN CLASS - UseCase4PalindromeCheckerApp
 * ================================================================
 *
 * Use Case 4: Character Array Based Validation
 *
 * Description:
 * This class validates a palindrome by converting
 * the string into a character array and comparing
 * characters using the two-pointer technique.
 *
 * At this stage, the application:
 * - Converts string to char array
 * - Uses start and end pointers
 * - Compares characters efficiently
 * - Displays the result
 *
 * This reduces extra memory usage.
 *
 * @author Developer
 * @version 4.0
 */

import java.util.Scanner;

public class UseCase4PalindromeCheckerApp {
    
    // Application Constants
    private static final String APP_NAME = "Palindrome Checker App";
    private static final String APP_VERSION = "4.0";
    
    /**
     * Application entry point for UC4.
     *
     * This is the first method executed by the JVM
     * when the program starts.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Execute Test Case 4: Character Array Based Palindrome Check
        testCase4();
    }
    
    /**
     * Test Case 4: Character Array Based Palindrome Check
     * 
     * Tests palindrome validation using character array
     * and two-pointer technique for efficient comparison.
     */
    public static void testCase4() {
        // Hardcoded string literal to be checked
        String testString = "level";
        
        // Convert string to character array
        char[] charArray = testString.toCharArray();
        
        // Check if palindrome using two-pointer approach
        boolean isPalindrome = isPalindromeUsingTwoPointer(charArray);
        
        // Display the validation result
        System.out.println("========================================");
        System.out.println("  Use Case 4: Character Array Check");
        System.out.println("========================================");
        System.out.println("\nString to check: \"" + testString + "\"");
        System.out.println("Character Array: " + java.util.Arrays.toString(charArray));
        
        if (isPalindrome) {
            System.out.println("\nResult: ??? IS a palindrome");
        } else {
            System.out.println("\nResult: ??? NOT a palindrome");
        }
        System.out.println();
    }
    
    /**
     * Checks if a character array represents a palindrome
     * using the two-pointer technique.
     *
     * This method demonstrates:
     * - Character array indexing
     * - Two-pointer technique for efficient comparison
     * - Time complexity: O(n/2) - early termination
     * - Space complexity: O(1) - no extra data structures
     *
     * @param charArray the character array to check
     * @return true if the array is a palindrome, false otherwise
     */
    public static boolean isPalindromeUsingTwoPointer(char[] charArray) {
        // Initialize two pointers: one at start, one at end
        int start = 0;
        int end = charArray.length - 1;
        
        // Use two-pointer technique to compare characters
        // Continue until pointers meet in the middle
        while (start < end) {
            // Compare characters at start and end positions
            // If they don't match, it's not a palindrome
            if (charArray[start] != charArray[end]) {
                return false;
            }
            
            // Move pointers towards the center
            start++;      // Move start pointer forward
            end--;        // Move end pointer backward
        }
        
        // If no mismatch found, it's a palindrome
        return true;
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
