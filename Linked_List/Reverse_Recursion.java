package Linked_List;

public class Reverse_Recursion {
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

    public Reverse_Recursion() {
        head = null;
        tail = null;
        size = 0;
    }
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    public int get(int index){
        if (index > size)
            return -1;
        Node temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.next;
        return temp.data;
    }
    public void addAtHead(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
        size++;

        if (head.next == null)
            tail = head;
    }
    public void addAtTail(int data){
        Node node = new Node(data);
        if (tail != null)
            tail.next = node;
        if (tail == null || size == 0)
            head = node;

        tail = node;
        size++;
    }
    public void addAtIndex(int index, int data){
        if (index < 0 || index > size)
            return;
        if (index == 0)
            addAtHead(data);
        else if (index == size)
            addAtTail(data);
        else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++)
                temp = temp.next;

            Node node = new Node(data);
            Node save = temp;
            temp = temp.next;
            save.next = node;
            node.next = temp;
            size++;
        }

    }
    public void deleteAtIndex(int index){
        if (size == 0 || index < 0 || index >= size)
            return;
        if (index == 0) {
            head = head.next;
            size--;
            if (size == 0)
                tail = null;
        }
        else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++)
                temp = temp.next;
            temp.next = temp.next.next;
            size--;

            if (temp.next == null)
                tail = temp;
        }
    }

    private Node reverseRecursion(Node head) {
        if (head == null || head.next == null)
            return head;

        Node rest = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public static void main(String[] args) {
        Reverse_Recursion list = new Reverse_Recursion();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);

        System.out.println("Given Linked list");
        list.printList(head);
        head = list.reverseRecursion(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
    }


}
