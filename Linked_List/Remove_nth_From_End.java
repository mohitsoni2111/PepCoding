package Linked_List;

public class Remove_nth_From_End {

    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static Node head;
    private Node tail;
    private int size;

    public Remove_nth_From_End() {
        head = null;
        tail = null;
        size = 0;
    }
    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static Node removeNthFromEnd(Node head, int n) {
        Node slow = head, fast = head;

        for (int i = 0; i < n; i++)
            fast = fast.next;

        if (fast == null)
            return head.next;

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        Remove_nth_From_End list = new Remove_nth_From_End();

        // creating first linked list
        list.head = new Node(3);
        list.head.next = new Node(6);
        list.head.next.next = new Node(9);
        list.head.next.next.next = new Node(15);
        list.head.next.next.next.next = new Node(30);

        System.out.println("\nCreated Linked list is:");
        list.printList();

        Node res = removeNthFromEnd(head, 3);

        System.out.println("\nLinked List after Deletion is:");
        list.printList();
    }
}
