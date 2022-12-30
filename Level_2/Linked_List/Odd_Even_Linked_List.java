package Level_2.Linked_List;

public class Odd_Even_Linked_List {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummyEven = new ListNode(-1);
        ListNode dummyOdd = new ListNode(-1);
        ListNode evenTail = dummyEven, oddTail = dummyOdd, curr = head;

        while (curr != null){
            if (curr.val % 2 != 0){
                oddTail.next = curr;
                oddTail = oddTail.next;
            } else {
                evenTail.next = curr;
                evenTail = evenTail.next;
            }
            curr = curr.next;
        }
        oddTail.next = dummyEven.next;
        evenTail.next = null;

        return dummyOdd.next;
    }
}
