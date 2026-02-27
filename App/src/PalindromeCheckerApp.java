/**
 * ================================================================
 * MAIN CLASS - UseCase6PalindromeCheckerApp
 * ================================================================
 *
 * Use Case 6: Queue + Stack Fairness Check
 *
 * Description:
 * This class demonstrates palindrome validation using
 * two different data structures:
 *
 * - Queue (FIFO - First In First Out)
 * - Stack (LIFO - Last In First Out)
 *
 * Characters are inserted into both structures and then
 * compared by removing from the front of the queue and
 * the top of the stack.
 *
 * If all characters match, the input string is confirmed
 * as a palindrome.
 *
 * This use case helps understand how FIFO and LIFO
 * behaviors can be combined for symmetric comparison.
 *
 * @author Developer
 * @version 6.0
 */

import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromeCheckerApp {
    
    // Application Constants
    private static final String APP_NAME = "Palindrome Checker App";
    private static final String APP_VERSION = "6.0";
    
    /**
     * Application entry point for UC6.
     *
     * This is the first method executed by the JVM
     * when the program starts.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Execute Test Case 6: Queue + Stack Based Palindrome Check
        testCase6();
    }
    
    /**
     * Test Case 6: Queue + Stack Based Palindrome Check
     * 
     * Tests palindrome validation using both Queue (FIFO) and Stack (LIFO).
     * Demonstrates how different data structures can be combined for validation.
     */
    public static void testCase6() {
        // Declare and initialize the input string
        String input = "radar";
        
        // Check if palindrome using Queue and Stack
        boolean isPalindrome = isPalindromeUsingQueueAndStack(input);
        
        // Display the validation result
        System.out.println("========================================");
        System.out.println("  Use Case 6: Queue + Stack Check");
        System.out.println("========================================");
        System.out.println("\nString to check: \"" + input + "\"");
        System.out.println("\nUsing Queue (FIFO) + Stack (LIFO)");
        System.out.println("Characters compared from both ends...");
        
        if (isPalindrome) {
            System.out.println("\nResult: ✓ IS a palindrome");
        } else {
            System.out.println("\nResult: ✗ NOT a palindrome");
        }
        System.out.println();
    }
    
    /**
     * Checks if a string is a palindrome using Queue and Stack.
     *
     * This method demonstrates:
     * - Queue creation with enqueue operations (FIFO)
     * - Stack creation with push operations (LIFO)
     * - Dequeue operation: removes from front (first in)
     * - Pop operation: removes from top (last in)
     * - Comparing elements from both structures
     * - Understanding FIFO vs LIFO behaviors
     *
     * @param str the string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindromeUsingQueueAndStack(String str) {
        // Create a Queue to store characters (FIFO - First In First Out)
        Queue<Character> queue = new LinkedList<>();
        
        // Create a Stack to store characters (LIFO - Last In First Out)
        Stack<Character> stack = new Stack<>();
        
        // Enqueue and Push each character of the string
        for (char c : str.toCharArray()) {
            queue.offer(c);  // Enqueue into queue
            stack.push(c);   // Push into stack
        }
        
        // Compare characters: dequeue from queue with pop from stack
        while (!queue.isEmpty() && !stack.isEmpty()) {
            // Dequeue from queue (removes from front - gets first character)
            char queueChar = queue.poll();
            
            // Pop from stack (removes from top - gets last character)
            char stackChar = stack.pop();
            
            // If characters don't match, not a palindrome
            if (queueChar != stackChar) {
                return false;
            }
        }
        
        // If all characters matched, it's a palindrome
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
