package Linked_List;

public class Cycle {

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

    public Cycle() {
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

    public static boolean detectLoop(Node head) {
        if (head == null)
            return false;

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Cycle llist = new Cycle();

        llist.addAtHead(20);
        llist.addAtHead(4);
        llist.addAtHead(15);
        llist.addAtHead(10);

        /*Create loop for testing */
        llist.head.next.next.next.next = llist.head;

        if (detectLoop(head))
            System.out.println("Loop found");
        else
            System.out.println("No Loop");
    }
}
