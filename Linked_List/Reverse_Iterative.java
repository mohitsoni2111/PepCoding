package Linked_List;

public class Reverse_Iterative {

    private static class Node {
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

    public Reverse_Iterative() {
        head = null;
        tail = null;
        size = 0;
    }
    private static void printList(Node node) {
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

    private Node reverse(Node node){
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }

    public static void main(String[] args) {
        Reverse_Iterative list = new Reverse_Iterative();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);

        System.out.println("Given Linked list");
        list.printList(head);
        head = list.reverse(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
    }
}
