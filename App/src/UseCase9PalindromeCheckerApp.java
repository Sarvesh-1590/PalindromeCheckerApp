/**
 * ================================================================
 * MAIN CLASS - UseCase9RecursivePalindrome
 * ================================================================
 *
 * Use Case 9: Recursive Palindrome Checker
 *
 * Description:
 * This class validates a palindrome using recursion.
 *
 * Characters are compared from the outer positions
 * moving inward using recursive calls.
 *
 * The recursion stops when:
 * - All characters are matched, or
 * - A mismatch is found.
 *
 * This use case demonstrates divide-and-conquer
 * logic using method recursion.
 *
 * @author Developer
 * @version 9.0
 */

public class UseCase9PalindromeCheckerApp {

    /**
     * Application entry point for UC9.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Execute Test Case 9: Recursive Palindrome Check
        testCase9();
    }

    /**
     * Test Case 9: Recursive Palindrome Check
     * 
     * Tests palindrome validation using recursion.
     */
    public static void testCase9() {
        // Declare and initialize the intput string
        String input = "radar";

        // Clean the string for recursion
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Check if palindrome using recursion
        boolean isPalindrome = check(cleaned, 0, cleaned.length() - 1);

        // Display the validation result
        System.out.println("========================================");
        System.out.println("  Use Case 9: Recursive Palindrome Check");
        System.out.println("========================================");
        System.out.println("\nString to check: \"" + input + "\"");
        System.out.println("\nUsing Method Recursion");
        System.out.println("Characters compared moving towards common center...");

        if (isPalindrome) {
            System.out.println("\nResult: ✓ IS a palindrome");
        } else {
            System.out.println("\nResult: ✗ NOT a palindrome");
        }
        System.out.println();
    }

    /**
     * Recursively checks whether a string is palindrome.
     *
     * @param s     Input string
     * @param start Starting index
     * @param end   Ending index
     * @return true if palindrome, otherwise false
     */
    private static boolean check(String s, int start, int end) {
        // Base Condition: If start meets or exceeds end, all matched
        if (start >= end) {
            return true;
        }

        // If characters at current positions don't match, not a palindrome
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }

        // Recursive call: Compare characters moving inward
        return check(s, start + 1, end - 1);
    }
}
