/**
 * ================================================================
 * MAIN CLASS - UseCasePalindromeApp
 * ================================================================
 *
 * Use Case 1: Application Entry & Welcome Message
 *
 * Description:
 * This class represents the entry point of the
 * Palindrome Checker Management System.
 *
 * At this stage, the application:
 * - Starts execution from the main() method
 * - Displays a welcome message
 * - Shows application version
 *
 * No palindrome logic is implemented yet.
 *
 * The goal is to establish a clear startup flow.
 *
 * @author Developer
 * @version 1.0
 */

import java.util.Scanner;

public class PalindromeCheckerApp {
    
    // Application Constants
    private static final String APP_NAME = "Palindrome Checker App";
    private static final String APP_VERSION = "1.0";
    
    /**
     * Application entry point.
     *
     * This is the first method executed by the JVM
     * when the program starts.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Execute Test Case 1: Application Entry & Welcome Message
        testCase1();
    }
    
    /**
     * Test Case 1: Application Entry & Welcome Message
     * 
     * Verifies that the application displays the welcome message
     * and application details upon startup.
     */
    public static void testCase1() {
        System.out.println("========================================");
        System.out.println("  Welcome to " + APP_NAME);
        System.out.println("  Version: " + APP_VERSION);
        System.out.println("========================================");
        System.out.println();
    }
    
    // Use Case 2: User Input Palindrome Check
    public static boolean isPalindrome(String str) {
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }
    
    // Use Case 2: Hardcoded Palindrome Tests
    public static void testHardcodedPalindromes() {
        String[] testCases = {"racecar", "madam", "level", "hello", "A", "noon"};
        
        System.out.println("\n\nUse Case 2: Hardcoded Palindrome Checks");
        System.out.println("----------------------------------------");
        for (String test : testCases) {
            boolean result = isPalindrome(test);
            String status = result ? "✓ PALINDROME" : "✗ NOT a palindrome";
            System.out.println("  \"" + test + "\" → " + status);
        }
    }
    
    // Use Case 3: Sentence Palindrome Tests (ignoring spaces and case)
    public static void testSentencePalindromes() {
        String[] sentenceTests = {
            "A man a plan a canal Panama",
            "Was it a car or a cat I saw",
            "Madam Im Adam",
            "race a car",
            "hello world"
        };
        
        System.out.println("\n\nUse Case 3: Sentence Palindrome Checks (ignoring spaces & case)");
        System.out.println("------------------------------------------------------------------");
        for (String sentence : sentenceTests) {
            boolean result = isPalindrome(sentence);
            String status = result ? "✓ PALINDROME" : "✗ NOT a palindrome";
            System.out.println("  \"" + sentence + "\" → " + status);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("======== Palindrome Checker App ========");
        System.out.println("\nUse Case 1: User Input Palindrome Check");
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to check: ");
        String userInput = scanner.nextLine();
        
        if (isPalindrome(userInput)) {
            System.out.println("✓ '" + userInput + "' is a palindrome!");
        } else {
            System.out.println("✗ '" + userInput + "' is NOT a palindrome.");
        }
        
        // Call Use Case 2
        testHardcodedPalindromes();
        
        // Call Use Case 3
        testSentencePalindromes();
        
        scanner.close();
    }
}
