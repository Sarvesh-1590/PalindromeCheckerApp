import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

/**
 * ================================================================
 * MAIN CLASS - UseCase13PalindromeCheckerApp
 * ================================================================
 *
 * Use Case 13: Performance Comparison
 *
 * Description:
 * This class measures and compares the execution
 * performance of palindrome validation algorithms.
 *
 * At this stage, the application:
 * - Uses a palindrome strategy implementation
 * - Captures execution start and end time
 * - Calculates total execution duration
 * - Displays benchmarking results
 *
 * This use case focuses purely on performance
 * measurement and algorithm comparison.
 *
 * The goal is to introduce benchmarking concepts.
 *
 * @author Developer
 * @version 13.0
 */

public class UseCase13PalindromeCheckerApp {

    /**
     * Application entry point for UC13.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Execute Test Case 13: Performance Benchmarking
        testCase13();
    }

    /**
     * Test Case 13: Performance Benchmarking
     * 
     * Compares execution time of different algorithms.
     */
    public static void testCase13() {
        String input = "A man a plan a canal Panama".repeat(100); // Larger input for better measurement

        System.out.println("===============================");
        System.out.println("  Use Case 13: Performance Comparison");
        System.out.println("===============================");
        System.out.println("\nInput size: " + input.length() + " characters");

        // Define strategies to compare
        PalindromeStrategyUC13[] strategies = {
                new StandardLoopStrategyUC13(),
                new StackStrategyUC13(),
                new DequeStrategyUC13()
        };

        for (PalindromeStrategyUC13 strategy : strategies) {
            benchmark(strategy, input);
        }

        System.out.println();
    }

    /**
     * Measures the execution time of a specific strategy.
     *
     * @param strategy The strategy to benchmark
     * @param input    The input string
     */
    private static void benchmark(PalindromeStrategyUC13 strategy, String input) {
        // Capture start time
        long startTime = System.nanoTime();

        // Execute algorithm
        boolean result = strategy.isValid(input);

        // Capture end time
        long endTime = System.nanoTime();

        // Calculate duration
        long duration = endTime - startTime;

        System.out.println("\nStrategy: " + strategy.getClass().getSimpleName());
        System.out.println("Result: " + (result ? "??? IS a palindrome" : "??? NOT a palindrome"));
        System.out.println("Execution Time: " + duration + " ns");
    }
}

/**
 * Interface for palindrome strategies.
 */
interface PalindromeStrategyUC13 {
    boolean isValid(String input);
}

/**
 * Standard Loop (Symmetric) Strategy.
 * Generally the most performant.
 */
class StandardLoopStrategyUC13 implements PalindromeStrategyUC13 {
    @Override
    public boolean isValid(String input) {
        if (input == null)
            return false;
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int n = cleaned.length();
        for (int i = 0; i < n / 2; i++) {
            if (cleaned.charAt(i) != cleaned.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Stack-Based Strategy.
 */
class StackStrategyUC13 implements PalindromeStrategyUC13 {
    @Override
    public boolean isValid(String input) {
        if (input == null)
            return false;
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : cleaned.toCharArray()) {
            stack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return cleaned.equals(reversed.toString());
    }
}

/**
 * Deque-Based Strategy.
 */
class DequeStrategyUC13 implements PalindromeStrategyUC13 {
    @Override
    public boolean isValid(String input) {
        if (input == null)
            return false;
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char c : cleaned.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}
