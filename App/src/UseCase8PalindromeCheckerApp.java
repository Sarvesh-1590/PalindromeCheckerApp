
/**
 * ================================================================
 * MAIN CLASS - UseCase8PalindromeCheckerApp
 * ================================================================
 *
 * Use Case 8: Linked List Based Palindrome Checker
 *
 * Description:
 * This class checks whether a string is a palindrome
 * using a Singly Linked List.
 *
 * Characters are added to the list and then compared
 * by removing elements from both ends:
 *
 * - removeFirst()
 * - removeLast()
 *
 * This demonstrates how LinkedList supports
 * double-ended operations for symmetric validation.
 *
 * @author Developer
 * @version 8.0
 */

public class UseCase8PalindromeCheckerApp {

    /**
     * Node class for Singly Linked List.
     * Represents each character in the list.
     */
    public static class Node {
        char data;
        Node next;

        /**
         * Constructor for creating a node.
         * 
         * @param data the character data
         */
        public Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Application entry point for UC8.
     *
     * This is the first method executed by the JVM
     * when the program starts.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Execute Test Case 8: Linked List Based Palindrome Check
        testCase8();
    }

    /**
     * Test Case 8: Linked List Based Palindrome Check
     * 
     * Tests palindrome validation using Singly Linked List.
     * Demonstrates node traversal and list manipulation.
     */
    public static void testCase8() {
        // Declare and initialize the input string
        String input = "hello";

        // Check if palindrome using Singly Linked List
        boolean isPalindrome = isPalindromeUsingLinkedList(input);

        // Display the validation result
        System.out.println("========================================");
        System.out.println("  Use Case 8: Linked List Check");
        System.out.println("========================================");
        System.out.println("\nString to check: \"" + input + "\"");
        System.out.println("\nUsing Singly Linked List");
        System.out.println("Characters compared using node traversal...");

        if (isPalindrome) {
            System.out.println("\nResult: ✓ IS a palindrome");
        } else {
            System.out.println("\nResult: ✗ NOT a palindrome");
        }
        System.out.println();
    }

    /**
     * Checks if a string is a palindrome using Singly Linked List.
     *
     * This method demonstrates:
     * - Creating a singly linked list from string characters
     * - Node traversal: sequential access using next references
     * - Fast and Slow Pointer Technique: finding the middle efficiently
     * - In-Place Reversal: reversing second half without extra memory
     * - Two-pointer comparison: comparing from both halves
     *
     * @param str the string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindromeUsingLinkedList(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }

        // Step 1: Create a singly linked list from the string
        Node head = null;
        Node tail = null;

        // Build the linked list by adding each character
        for (char c : str.toCharArray()) {
            Node newNode = new Node(c);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Step 2: Use Fast and Slow Pointer to find the middle
        Node slow = head;
        Node fast = head;
        Node prev = null;

        // Move slow by 1 and fast by 2 to find middle
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 3: Reverse the second half of the list (in-place reversal)
        Node middle = null;

        if (prev != null) {
            prev.next = null; // Disconnect first half
            middle = reverseLinkedList(slow);
        }

        // Step 4: Compare first half with reversed second half
        Node firstHalf = head;
        Node secondHalf = middle;

        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    /**
     * Reverses a singly linked list in-place.
     *
     * This method demonstrates:
     * - In-place reversal: modifying next pointers
     * - Node pointer manipulation: prev, current, next
     * - No extra data structures: O(1) space complexity
     *
     * @param head the head of the list to reverse
     * @return the new head of the reversed list
     */
    public static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node current = head;
        Node next;

        // Traverse and reverse by changing next pointers
        while (current != null) {
            next = current.next; // Save next node
            current.next = prev; // Reverse the link
            prev = current; // Move prev forward
            current = next; // Move current forward
        }

        return prev; // New head of reversed list
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
