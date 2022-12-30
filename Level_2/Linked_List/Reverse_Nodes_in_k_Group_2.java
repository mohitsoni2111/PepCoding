package Level_2.Linked_List;

import java.util.Scanner;

public class Reverse_Nodes_in_k_Group_2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static int length(ListNode node){
        ListNode curr = null;
        int len = 0;
        while (curr != null){
            curr = curr.next;
            len++;
        }
        return len;
    }
    public static ListNode tempHead = null;
    public static ListNode tempTail = null;
    public static void addFirst(ListNode node){
        if (tempHead == null){
            tempHead = node;
            tempTail = node;
        } else {
            node.next = tempHead;
            tempHead = node;

        }
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode originalHead = null, originalTail = null;
        int len = length(head);
        ListNode curr = head;

        while (len >= k){
            int tempK = k;
            while (tempK-- > 0){
                ListNode frwd = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = frwd;
            }
            if (originalHead == null){
                originalHead = tempHead;
                originalTail = tempTail;
            } else {
                originalTail.next = tempHead;
                originalTail = tempTail;
            }
            tempHead = null;
            tempTail = null;
            len -= k;
        }
        originalTail.next = curr;
        return originalHead;
    }

    public static Scanner scn = new Scanner(System.in);
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }
    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);

        int k = scn.nextInt();
        h1 = reverseKGroup(h1, k);
        printList(h1);
    }
}
