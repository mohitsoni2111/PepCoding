package Linked_List;

public class Merge_Two_Sorted_Lists {
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

    public Merge_Two_Sorted_Lists() {
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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;

        if (l1.data < l2.data){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        Merge_Two_Sorted_Lists list = new Merge_Two_Sorted_Lists();

        head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);

        head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);

        System.out.println("\n1st Linked list is:");
        list.printList(head1);
        System.out.println();

        System.out.println("\n2nd Linked list is:");
        list.printList(head2);
        System.out.println();

        ListNode res = mergeTwoLists(head1, head2);

        System.out.println("\nLinked List after Merge is:");
        list.printList(res);
    }
}
