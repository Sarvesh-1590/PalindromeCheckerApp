
/**
 * ================================================================
 * MAIN CLASS - UseCase1PalindromeCheckerApp
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

public class UseCase1PalindromeCheckerApp {

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

}
