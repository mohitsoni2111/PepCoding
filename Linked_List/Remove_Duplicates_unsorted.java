package Linked_List;

import java.util.HashSet;

public class Remove_Duplicates_unsorted {
    public static class ListNode {
        int data;
        ListNode next;
        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static ListNode head;

    public Remove_Duplicates_unsorted() {
        head = null;
    }
    public void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static ListNode removeDuplicatesUnsorted(ListNode head){
        if (head == null) return null;
        if (head.next == null) return head;

        HashSet<Integer> set = new HashSet<>();
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null){
            int currentVal = curr.data;

            if (set.contains(currentVal))
                prev.next = curr.next;
            else {
                set.add(currentVal);
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Remove_Duplicates_unsorted list = new Remove_Duplicates_unsorted();

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(3);

        System.out.println("\nCreated Linked list is:");
        list.printList(head);
        System.out.println();

        ListNode node = removeDuplicatesUnsorted(head);

        System.out.println("\nLinked list after removing duplicates:");
        list.printList(node);
        System.out.println();
    }
}
