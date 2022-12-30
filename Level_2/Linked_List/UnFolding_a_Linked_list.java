package Level_2.Linked_List;

import java.util.Scanner;

public class UnFolding_a_Linked_list {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;

        return head;
    }
    public static void unfold(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode firstHead = head;
        ListNode firstPrevious = firstHead;
        ListNode secondHead = head.next;
        ListNode secondPrevious = secondHead;

        while (secondPrevious != null && secondPrevious.next != null){  //Even && Odd Case
            // Backup
            ListNode forward = secondPrevious.next;

            // Links
            firstPrevious.next = forward;
            secondPrevious.next = forward.next;

            firstPrevious = firstPrevious.next;
            secondPrevious = secondPrevious.next;
        }
        firstPrevious.next = null;      // Odd case

        secondHead = reverse(secondHead);

        firstPrevious.next = secondHead;
    }
    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}
