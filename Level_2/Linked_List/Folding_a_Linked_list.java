package Level_2.Linked_List;

import java.util.Scanner;

public class Folding_a_Linked_list {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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
    public static void fold(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode middle = middleNode(head);
        ListNode newHead = middle.next;
        middle.next = null;

        newHead = reverse(newHead);

        ListNode c1 = head;
        ListNode c2 = newHead;
        ListNode f1 = null;
        ListNode f2 = null;

        while (c2 != null){
            // Backup
            f1 = c1.next;
            f2 = c2.next;

            // Links
            c1.next = c2;
            c2.next = f1;

            // Move
            c1 = f1;
            c2 = f2;
        }
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
        fold(head);
        printList(head);
    }
}
