
import java.util.*;

public class MergeTwoSLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to merge two sorted linked lists
    public static Node mergeSortedLists(Node head1, Node head2) {
        // Dummy node to help with merging
        Node dummy = new Node(-1);
        Node current = dummy;

        // Traverse both lists and merge
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        // Attach the remaining elements of either list
        if (head1 != null) {
            current.next = head1;
        } else if (head2 != null) {
            current.next = head2;
        }

        return dummy.next; // Return the merged list starting from the next node
    }

    // Utility function to print a linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create first sorted linked list: 1 -> 3 -> 5
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);

        // Create second sorted linked list: 2 -> 4 -> 6
        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);

        System.out.println("List 1:");
        printList(head1);

        System.out.println("List 2:");
        printList(head2);

        // Merge the lists
        Node mergedHead = mergeSortedLists(head1, head2);

        System.out.println("Merged List:");
        printList(mergedHead);
}
}
