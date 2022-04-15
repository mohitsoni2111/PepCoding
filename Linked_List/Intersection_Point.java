package Linked_List;

public class Intersection_Point {

    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static Node head1, head2;
    private Node tail;
    private int size;

    public Intersection_Point() {
        head1 = null;
        head2 = null;
        tail = null;
        size = 0;
    }

    public static Node getIntersectionNode(Node headA, Node headB) {
        Node ptr1 = headA;
        Node ptr2 = headB;

        if (ptr1 == null || ptr2 ==null) return null;

        while (ptr1 != ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;

            if (ptr1 == ptr2)
                return ptr1;

            if (ptr1 == null)
                ptr1 = headB;

            if (ptr2 == null)
                ptr2 = headA;
        }
        return ptr1;
    }

    public static void main(String[] args) {
        Intersection_Point list = new Intersection_Point();

        // creating first linked list
        list.head1 = new Node(3);
        list.head1.next = new Node(6);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(15);
        list.head1.next.next.next.next = new Node(30);

        // creating second linked list
        list.head2 = new Node(10);
        list.head2.next = new Node(15);
        list.head2.next.next = new Node(30);

        Node res = getIntersectionNode(head1, head2);
        if (res == null)
            System.out.print("No Intersection");
        else
            System.out.print("Intersected at : " +  res.data);
    }
}
