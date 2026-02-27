/**
 * ================================================================
 * MAIN CLASS - UseCase7PalindromeCheckerApp
 * ================================================================
 *
 * Use Case 7: Deque Based Optimized Palindrome Checker
 *
 * Description:
 * This class validates a palindrome using a Deque
 * (Double Ended Queue).
 *
 * Characters are inserted into the deque and then
 * compared by removing elements from both ends:
 *
 * - removeFirst()
 * - removeLast()
 *
 * This avoids reversing the string and provides an
 * efficient front-to-back comparison approach.
 *
 * This use case demonstrates optimal bidirectional
 * traversal using Deque.
 *
 * @author Developer
 * @version 7.0
 */

import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;

public class PalindromeCheckerApp {
    
    // Application Constants
    private static final String APP_NAME = "Palindrome Checker App";
    private static final String APP_VERSION = "7.0";
    
    /**
     * Application entry point for UC7.
     *
     * This is the first method executed by the JVM
     * when the program starts.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Execute Test Case 7: Deque Based Optimized Palindrome Check
        testCase7();
    }
    
    /**
     * Test Case 7: Deque Based Optimized Palindrome Check
     * 
     * Tests palindrome validation using Deque (Double Ended Queue).
     * Demonstrates efficient bidirectional character comparison.
     */
    public static void testCase7() {
        // Declare and initialize the input string
        String input = "kayak";
        
        // Check if palindrome using Deque
        boolean isPalindrome = isPalindromeUsingDeque(input);
        
        // Display the validation result
        System.out.println("========================================");
        System.out.println("  Use Case 7: Deque Based Check");
        System.out.println("========================================");
        System.out.println("\nString to check: \"" + input + "\"");
        System.out.println("\nUsing Deque (Double Ended Queue)");
        System.out.println("Characters compared from both ends...");
        
        if (isPalindrome) {
            System.out.println("\nResult: ✓ IS a palindrome");
        } else {
            System.out.println("\nResult: ✗ NOT a palindrome");
        }
        System.out.println();
    }
    
    /**
     * Checks if a string is a palindrome using Deque.
     *
     * This method demonstrates:
     * - Deque creation: a double-ended queue
     * - addFirst/addLast operations: insertion at both ends
     * - removeFirst operation: removes from front
     * - removeLast operation: removes from rear
     * - Bidirectional traversal: comparing from both ends simultaneously
     * - Optimized data handling: no separate reversal structures needed
     *
     * @param str the string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindromeUsingDeque(String str) {
        // Create a Deque to store characters
        // LinkedList implements Deque interface
        Deque<Character> deque = new LinkedList<>();
        
        // Insert each character of the string into the deque
        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }
        
        // Compare characters by removing from both ends
        while (deque.size() > 1) {
            // Remove first character from the front
            char firstChar = deque.removeFirst();
            
            // Remove last character from the rear
            char lastChar = deque.removeLast();
            
            // If characters don't match, not a palindrome
            if (firstChar != lastChar) {
                return false;
            }
        }
        
        // If all comparisons matched, it's a palindrome
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
