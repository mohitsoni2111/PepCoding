package Linked_List;

public class Add_Two_Numbers {
    public static class ListNode {
        int data;
        ListNode next;
        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static ListNode head1, head2;
    private ListNode tail;
    private int size;

    public Add_Two_Numbers() {
        head1 = null;
        head2 = null;
        tail = null;
        size = 0;
    }
    public void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    // Reverse sorted (342 + 465 = 807)
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyhead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyhead;

        while (p != null || q != null){
            int x = (p!=null) ? p.data : 0;
            int y = (q!=null) ? q.data : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (p != null) p = p.next;
            if (q != null) p = q.next;
        }
        if (carry == 1) curr.next = new ListNode(carry);

        return dummyhead.next;
    }

    public static void main(String[] args) {
        Add_Two_Numbers list = new Add_Two_Numbers();

        head1 = new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);

        head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(4);

        System.out.println("\n1st Linked list is:");
        list.printList(head1);
        System.out.println();

        System.out.println("\n2nd Linked list is:");
        list.printList(head2);
        System.out.println();

        ListNode res = addTwoNumbers(head1, head2);

        System.out.println("\nLinked List after adding is:");
        list.printList(res);
    }
}
