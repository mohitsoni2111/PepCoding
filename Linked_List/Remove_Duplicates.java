package Linked_List;

public class Remove_Duplicates {

    public static class ListNode {
        int data;
        ListNode next;
        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static ListNode head;

    public Remove_Duplicates() {
        head = null;
    }
    public void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static ListNode removeDuplicates(ListNode head){
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode curr = head;
        while (curr != null){
            ListNode temp = curr;

            while (temp !=null && temp.data == curr.data)
                temp = temp.next;

            curr.next = temp;
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Remove_Duplicates list = new Remove_Duplicates();

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);

        System.out.println("\nCreated Linked list is:");
        list.printList(head);
        System.out.println();

        ListNode node = removeDuplicates(head);

        System.out.println("\nLinked list after removing duplicates:");
        list.printList(node);
        System.out.println();
    }
}
