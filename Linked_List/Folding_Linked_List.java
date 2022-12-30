package Linked_List;

public class Folding_Linked_List {
    public static class ListNode {
        int data;
        ListNode next;
        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private static ListNode head;
    static int size;
    public Folding_Linked_List() {
        head = null;
    }
    public void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    public static int findSize(ListNode head){
        while (head != null){
            head = head.next;
            size++;
        }
        return size;
    }
    static ListNode left;
    public static void foldHelper(ListNode right, int size, int floor){
        if (right == null) return;

        foldHelper(right.next, size, floor + 1);

        if (floor > size / 2) {
            ListNode temp = left.next;
            left.next = right;
            right.next = temp;
            left = temp;
        }
        else if (floor == size / 2){
            right.next = null;
        }
    }
    public static ListNode fold(ListNode head){
        int size = findSize(head);
        left = head;
        foldHelper(head ,size, 0);
        return head;
    }

    public static void main(String[] args) {
        Folding_Linked_List list = new Folding_Linked_List();

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println("\nCreated Linked list is:");
        list.printList(head);
        System.out.println();

        ListNode node = fold(head);

        System.out.println("\nLinked list after folding:");
        list.printList(node);
        System.out.println();
    }
}
