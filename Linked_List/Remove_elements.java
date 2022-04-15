// Given the head of a linked list and an integer val,
// remove all the nodes of the linked list that has Node.val == val, and return the new head.

package Linked_List;

public class Remove_elements {
    public static class ListNode {
        int data;
        ListNode next;
        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static ListNode head;
    private ListNode tail;
    private int size;

    public Remove_elements() {
        head = null;
        tail = null;
        size = 0;
    }
    public void printList() {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        ListNode curr = head, prev = null;
        while (curr != null){
            if (curr.data == val) {
                if (prev != null)
                    prev.next = curr.next;
                else
                    head = head.next;
            }
            else
                prev = curr;

            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Remove_elements list = new Remove_elements();

        // creating first linked list
        list.head = new ListNode(3);
        list.head.next = new ListNode(6);
        list.head.next.next = new ListNode(9);
        list.head.next.next.next = new ListNode(15);
        list.head.next.next.next.next = new ListNode(9);
        list.head.next.next.next.next.next = new ListNode(30);
        list.head.next.next.next.next.next.next = new ListNode(2);

        System.out.println("\nCreated Linked list is:");
        list.printList();

        ListNode res = removeElements(head, 9);

        System.out.println("\nLinked List after Deletion is:");
        list.printList();
    }
}
