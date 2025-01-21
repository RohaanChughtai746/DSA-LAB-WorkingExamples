/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignments;

/**
 *
 * @author HP
 */
public class LinkedList {

    // Inner Node class
    static class Node {
        int data;
        Node next;

        // Constructor
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to display the list in reverse using recursion
    public static void displayReverse(Node head) {
        if (head == null) 
            return; // Base case
        displayReverse(head.next); // Recursive call
        System.out.print(head.data + " "); // Print data after recursion
    }

    // Method to print the list normally
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " "); // Print current node's data
            head = head.next; // Move to the next node
        }
    }

    // Main method
    public static void main(String[] args) {
        // Create linked list nodes
        Node a = new Node(5);
        Node b = new Node(23);
        Node c = new Node(44);
        Node d = new Node(22);

        // Link nodes
        a.next = b;
        b.next = c;
        c.next = d;

        // Print the linked list
        System.out.print("Original List: ");
        printList(a);
        System.out.println();

        // Display the list in reverse
        System.out.print("Reversed List: ");
        displayReverse(a);
    }
}
