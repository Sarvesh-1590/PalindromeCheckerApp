/**
 * ================================================================
 * MAIN CLASS - UseCase5PalindromeCheckerApp
 * ================================================================
 *
 * Use Case 5: Stack Based Palindrome Checker
 *
 * Description:
 * This class validates a palindrome using a Stack
 * data structure which follows the LIFO principle.
 *
 * At this stage, the application:
 * - Pushes characters into a stack
 * - Pops them in reverse order
 * - Compares with original sequence
 * - Displays the result
 *
 * This maps stack behavior to reversal logic.
 *
 * @author Developer
 * @version 5.0
 */

import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {
    
    // Application Constants
    private static final String APP_NAME = "Palindrome Checker App";
    private static final String APP_VERSION = "5.0";
    
    /**
     * Application entry point for UC5.
     *
     * This is the first method executed by the JVM
     * when the program starts.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Execute Test Case 5: Stack Based Palindrome Check
        testCase5();
    }
    
    /**
     * Test Case 5: Stack Based Palindrome Check
     * 
     * Tests palindrome validation using Stack data structure.
     * Demonstrates LIFO principle for character reversal.
     */
    public static void testCase5() {
        // Declare and initialize the input string
        String input = "noon";
        
        // Check if palindrome using Stack
        boolean isPalindrome = isPalindromeUsingStack(input);
        
        // Display the validation result
        System.out.println("========================================");
        System.out.println("  Use Case 5: Stack Based Checker");
        System.out.println("========================================");
        System.out.println("\nString to check: \"" + input + "\"");
        
        if (isPalindrome) {
            System.out.println("Result: ✓ IS a palindrome");
        } else {
            System.out.println("Result: ✗ NOT a palindrome");
        }
        System.out.println();
    }
    
    /**
     * Checks if a string is a palindrome using Stack data structure.
     *
     * This method demonstrates:
     * - Stack creation and usage
     * - Push operation: inserting characters
     * - Pop operation: removing in LIFO order
     * - Reversal logic through LIFO principle
     *
     * @param str the string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindromeUsingStack(String str) {
        // Create a Stack to store characters
        Stack<Character> stack = new Stack<>();
        
        // Push each character of the string into the stack
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        
        // Assume palindrome initially
        boolean isPalindrome = true;
        
        // Pop characters from stack and compare with original order
        for (char c : str.toCharArray()) {
            // Pop character from stack (removes from top - LIFO)
            char poppedChar = stack.pop();
            
            // If popped character doesn't match current position, not a palindrome
            if (c != poppedChar) {
                isPalindrome = false;
                break;
            }
        }
        
        return isPalindrome;
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
