// Given the head of a singly linked list, group all the nodes with odd indices together 
// followed by the nodes with even indices, and return the reordered list.
package Linked_List;

public class Odd_Even_Linked_List {

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

    public Odd_Even_Linked_List() {
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

    public static ListNode oddEvenList(ListNode head) {
        if(head==null) return null;

        ListNode evenHead=head.next;
        ListNode oddWalker=head;
        ListNode evenWalker=evenHead;

        while(evenWalker!=null && evenWalker.next!=null){
            oddWalker.next = oddWalker.next.next;
            evenWalker.next = evenWalker.next.next;
            oddWalker = oddWalker.next;
            evenWalker = evenWalker.next;
        }
        oddWalker.next = evenHead;
        return head;
    }


    public static void main(String[] args) {
        Odd_Even_Linked_List list = new Odd_Even_Linked_List();

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

        ListNode res = oddEvenList(head);

        System.out.println("\nLinked List after arrangement is:");
        list.printList();
    }
}
