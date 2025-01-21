/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignments;

/**
 *
 * @author HP
 */
class SinglyLinkedList {
    Node head;

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    
    public int getLength() {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    
    public void printMiddleNode() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle Node: " + slow.data);
    }

    
    public SinglyLinkedList reverseCopy() {
        SinglyLinkedList reversedList = new SinglyLinkedList();
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.data);
            newNode.next = reversedList.head;
            reversedList.head = newNode;
            current = current.next;
        }
        return reversedList;
    }

   
    public void removeDuplicates() {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next; // Remove duplicate
            } else {
                current = current.next;
            }
        }
    }

  
    public static SinglyLinkedList mergeSorted(SinglyLinkedList list1, SinglyLinkedList list2) {
        SinglyLinkedList mergedList = new SinglyLinkedList();
        Node dummy = new Node(0); // Dummy node to start building the merged list
        Node tail = dummy;

        Node ptr1 = list1.head, ptr2 = list2.head;

        while (ptr1 != null && ptr2 != null) {
            if (ptr1.data <= ptr2.data) {
                tail.next = ptr1;
                ptr1 = ptr1.next;
            } else {
                tail.next = ptr2;
                ptr2 = ptr2.next;
            }
            tail = tail.next;
        }

        
        if (ptr1 != null) tail.next = ptr1;
        if (ptr2 != null) tail.next = ptr2;

        mergedList.head = dummy.next;
        return mergedList;
    }

   
    public void deleteList() {
        head = null;
        System.out.println("List has been deleted.");
    }

   
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

   
    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    
    public static void main(String[] args) {
        // Create and populate the first SLL
        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(2);
        list1.addNode(3);
        list1.addNode(4);

        System.out.println("Original List 1:");
        list1.printList();

        
        System.out.println("Length of List 1: " + list1.getLength());

        
        list1.printMiddleNode();


        SinglyLinkedList reversedList = list1.reverseCopy();
        System.out.println("Reversed List (Copy):");
        reversedList.printList();


        list1.removeDuplicates();
        System.out.println("List 1 after Removing Duplicates:");
        list1.printList();

    
        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.addNode(2);
        list2.addNode(5);
        list2.addNode(6);

        System.out.println("Original List 2:");
        list2.printList();


        SinglyLinkedList mergedList = mergeSorted(list1, list2);
        System.out.println("Merged List:");
        mergedList.printList();


        list1.deleteList();
        list1.printList(); 
    }
}

