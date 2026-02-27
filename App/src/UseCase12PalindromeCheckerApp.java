import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

/**
 * ================================================================
 * MAIN CLASS - UseCase12PalindromeCheckerApp
 * ================================================================
 *
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 *
 * Description:
 * This class demonstrates how different palindrome
 * validation algorithms can be selected dynamically
 * at runtime using the Strategy Design Pattern.
 *
 * At this stage, the application:
 * - Defines a common PalindromeStrategy interface
 * - Implements a concrete Stack based strategy
 * - Implements a concrete Deque based strategy
 * - Injects the strategy at runtime
 * - Executes the selected algorithm
 *
 * No performance comparison is done in this use case.
 * The focus is purely on algorithm interchangeability.
 *
 * The goal is to teach extensible algorithm design.
 *
 * @author Developer
 * @version 12.0
 */

public class UseCase12PalindromeCheckerApp {

    /**
     * Application entry point for UC12.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Execute Test Case 12: Strategy Pattern Demo
        testCase12();
    }

    /**
     * Test Case 12: Strategy Pattern Demo
     * 
     * Demonstrates dynamic algorithm selection.
     */
    public static void testCase12() {
        String input = "radar";

        System.out.println("========================================");
        System.out.println("  Use Case 12: Strategy Pattern Demo");
        System.out.println("========================================");
        System.out.println("\nString to check: \"" + input + "\"");

        // 1. Using Stack Strategy
        PalindromeStrategy stackStrategy = new StackStrategy();
        executeStrategy(stackStrategy, input);

        // 2. Using Deque Strategy
        PalindromeStrategy dequeStrategy = new DequeStrategy();
        executeStrategy(dequeStrategy, input);

        System.out.println();
    }

    /**
     * Executes the provided palindrome strategy.
     *
     * @param strategy The algorithm strategy to use
     * @param input    The string to check
     */
    private static void executeStrategy(PalindromeStrategy strategy, String input) {
        boolean result = strategy.isValid(input);

        System.out.println("\nUsing Strategy: " + strategy.getClass().getSimpleName());
        if (result) {
            System.out.println("Result: ✓ IS a palindrome");
        } else {
            System.out.println("Result: ✗ NOT a palindrome");
        }
    }
}

/**
 * ================================================================
 * INTERFACE - PalindromeStrategy
 * ================================================================
 *
 * This interface defines a contract for all
 * palindrome checking algorithms.
 *
 * Any new algorithm must implement this interface
 * and provide its own validation logic.
 */
interface PalindromeStrategy {
    /**
     * Checks if the given string is a palindrome.
     *
     * @param input the string to check
     * @return true if palindrome, false otherwise
     */
    boolean isValid(String input);
}

/**
 * ================================================================
 * CLASS - StackStrategy
 * ================================================================
 *
 * Concrete implementation using a Stack data structure.
 */
class StackStrategy implements PalindromeStrategy {
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
 * ================================================================
 * CLASS - DequeStrategy
 * ================================================================
 *
 * Concrete implementation using a Deque (Double Ended Queue).
 */
class DequeStrategy implements PalindromeStrategy {
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
