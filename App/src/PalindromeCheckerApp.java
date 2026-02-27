import java.util.Scanner;

public class PalindromeCheckerApp {
    
    // Use Case 1: User Input Palindrome Check
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
        
        scanner.close();
    }
}
