// https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1295/

package Linked_List;

public class Rotate_List {
    public class ListNode {
        int val;
        ListNode next;ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        if(k == 0) return head;

        ListNode curr = head;
        int length = 1;
        while (curr != null){
            curr = curr.next;
            length++;
        }

        if (k == length) return head;
        k = ((k % length) + length) % length;       // To make left or right rotation -> clockwise rotation

        curr.next = head;
        curr = head;

        for (int i = 0; i < length - k - 1; i++)
            curr = curr.next;

        head = curr.next;
        curr.next = null;

        return head;
    }
}
