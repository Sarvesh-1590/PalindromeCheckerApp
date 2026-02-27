/**
 * ================================================================
 * MAIN CLASS - UseCase10PalindromeCheckerApp
 * ================================================================
 *
 * Use Case 10: Normalized Palindrome Validation
 *
 * Description:
 * This class validates a palindrome after preprocessing
 * the input string.
 *
 * Normalization includes:
 * - Removing spaces and symbols
 * - Converting to lowercase
 *
 * This ensures the palindrome check is logical rather
 * than character-format dependent.
 *
 * Example:
 * "A man a plan a canal Panama"
 *
 * @author Developer
 * @version 10.0
 */

public class UseCase10PalindromeCheckerApp {

    /**
     * Application entry point for UC10.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Execute Test Case 10: Normalized Palindrome Check
        testCase10();
    }

    /**
     * Test Case 10: Normalized Palindrome Check
     * 
     * Tests palindrome validation ignoring case, spaces and symbols.
     */
    public static void testCase10() {
        // Declare and initialize the input string
        String input = "A man a plan a canal Panama";

        // Step 1: Normalize the string
        // Remove spaces and symbols using Regex, and convert to lowercase
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Step 2: Validate palindrome using symmetric comparison
        boolean isPalindrome = isPalindromeNormalized(normalized);

        // Display the validation result
        System.out.println("===============================");
        System.out.println("  Use Case 10: Normalized Check");
        System.out.println("===============================");
        System.out.println("\nOriginal String: \"" + input + "\"");
        System.out.println("Normalized String: \"" + normalized + "\"");
        System.out.println("\nRequirement: Ignore case, spaces and symbols.");

        if (isPalindrome) {
            System.out.println("\nResult: ??? IS a logical palindrome");
        } else {
            System.out.println("\nResult: ??? NOT a logical palindrome");
        }
        System.out.println();
    }

    /**
     * Validates if a normalized string is a palindrome.
     * Uses symmetric comparison from both ends.
     *
     * @param normalized the preprocessed string
     * @return true if palindrome, otherwise false
     */
    public static boolean isPalindromeNormalized(String normalized) {
        // Compare characters from both ends
        for (int i = 0; i < normalized.length() / 2; i++) {

            // Compare symmetric characters
            if (normalized.charAt(i) != normalized.charAt(normalized.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
