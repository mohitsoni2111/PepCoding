package Linked_List;

public class Palindrome {
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

    public Palindrome() {
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

    static ListNode left;
    public static boolean isPalinMain(ListNode right){
        if(right==null) return true;

        boolean isp = isPalindrome(right.next);

        if (isp == false) return false;

        boolean isp2 = (left.data == right.data);
        left = left.next;

        return isp2;
    }

    public static boolean isPalindrome(ListNode right) {
        left = head;
        boolean result = isPalinMain(right);
        return result;
    }

    public static void main(String[] args) {
        Palindrome list = new Palindrome();

        list.head = new ListNode(1);
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(3);
        list.head.next.next.next = new ListNode(3);
        list.head.next.next.next.next = new ListNode(2);
        list.head.next.next.next.next.next = new ListNode(1);

        System.out.println("\nCreated Linked list is:");
        list.printList();
        System.out.println();

        if (isPalindrome(head))
            System.out.println("Loop found");
        else
            System.out.println("No Loop");
    }
}
