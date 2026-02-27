/**
 * ================================================================
 * MAIN CLASS - UseCase11PalindromeCheckerApp
 * ================================================================
 *
 * Use Case 11: Object-Oriented Palindrome Service
 *
 * Description:
 * This class demonstrates palindrome validation using
 * object-oriented design.
 *
 * The palindrome logic is encapsulated inside a
 * PalindromeService class.
 *
 * This improves:
 * - Reusability
 * - Readability
 * - Separation of concerns
 *
 * @author Developer
 * @version 11.0
 */

public class UseCase11PalindromeCheckerApp {

    /**
     * Application entry point for UC11.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Execute Test Case 11: Object-Oriented Palindrome Check
        testCase11();
    }

    /**
     * Test Case 11: Object-Oriented Palindrome Check
     * 
     * Demonstrates encapsulation by using a service class.
     */
    public static void testCase11() {
        String input = "madam";

        // Create an instance of the service (Encapsulation)
        PalindromeService service = new PalindromeService();

        // Use the service to check palindrome
        boolean isPalindrome = service.checkPalindrome(input);

        // Display results
        System.out.println("========================================");
        System.out.println("  Use Case 11: Object-Oriented Check");
        System.out.println("========================================");
        System.out.println("\nString to check: \"" + input + "\"");
        System.out.println("\nApproach: Service-Based Encapsulation");
        System.out.println("Logic handled by: PalindromeService class");

        if (isPalindrome) {
            System.out.println("\nResult: ✓ IS a palindrome");
        } else {
            System.out.println("\nResult: ✗ NOT a palindrome");
        }
        System.out.println();
    }
}

/**
 * Service class that contains palindrome logic.
 */
class PalindromeService {

    /**
     * Checks whether the input string is a palindrome.
     *
     * @param input Input string
     * @return true if palindrome, false otherwise
     */
    public boolean checkPalindrome(String input) {
        if (input == null)
            return false;

        // Clean the string
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Standard symmetric comparison
        int length = cleaned.length();
        for (int i = 0; i < length / 2; i++) {
            if (cleaned.charAt(i) != cleaned.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
