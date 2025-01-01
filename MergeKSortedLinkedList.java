import java.util.*;

public class MergeKSortedLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to merge two sorted linked lists
    public static Node mergeTwoLists(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node current = dummy;

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

        if (head1 != null) {
            current.next = head1;
        } else if (head2 != null) {
            current.next = head2;
        }

        return dummy.next;
    }

    // Function to merge k sorted linked lists using divide and conquer
    public static Node mergeKLists(Node[] lists) {
        if (lists == null || lists.length == 0) return null;

        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i += interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }

        return lists[0];
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
        // Create sample sorted linked lists
        Node list1 = new Node(1);
        list1.next = new Node(4);
        list1.next.next = new Node(7);

        Node list2 = new Node(2);
        list2.next = new Node(5);
        list2.next.next = new Node(8);

        Node list3 = new Node(3);
        list3.next = new Node(6);
        list3.next.next = new Node(9);

        // Add lists to an array
        Node[] lists = {list1, list2, list3};

        // Print initial lists
        System.out.println("Initial Linked Lists:");
        for (int i = 0; i < lists.length; i++) {
            System.out.print("List " + (i + 1) + ": ");
            printList(lists[i]);
        }

        // Merge all lists
        Node mergedHead = mergeKLists(lists);

        // Print merged list
        System.out.println("Merged Linked List:");
        printList(mergedHead);
    }
}

    

