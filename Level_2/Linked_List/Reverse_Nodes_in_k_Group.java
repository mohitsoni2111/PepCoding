package Level_2.Linked_List;

public class Reverse_Nodes_in_k_Group {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        for (ListNode i = head; i != null; n++, i = i.next);

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        for (ListNode prev = dummy, tail = head; n >= k; n -= k){
            for (int i = 1; i < k; i++){
                ListNode next = tail.next.next;
                tail.next.next = prev.next;
                prev.next = tail.next;
                tail.next = next;
            }
            prev = tail;
            tail = tail.next;
        }
        return dummy.next;
    }
}
