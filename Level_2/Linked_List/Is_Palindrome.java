package Level_2.Linked_List;

import java.util.Scanner;

public class Is_Palindrome {
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
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode middle = middleNode(head);
        ListNode newHead = middle.next;
        middle.next = null;

        newHead = reverse(newHead);

        ListNode c1 = head;
        ListNode c2 = newHead;
        boolean result = true;

        while (c2 != null){         // c1 != null has been removed bcoz of odd length case
            if (c1.val != c2.val){
                result = false;
                break;
            }
            c1 = c1.next;
            c2 = c2.next;
        }

        newHead = reverse(newHead);
        middle.next = newHead;

        return result;
    }
    public void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        boolean ans = isPalindrome(dummy.next);
        System.out.print(ans);
    }
}
