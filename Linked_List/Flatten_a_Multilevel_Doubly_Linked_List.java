// https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1225/

package Linked_List;

public class Flatten_a_Multilevel_Doubly_Linked_List {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    Node pre = null;
    public Node flatten(Node head) {
        if(head == null) return null;

        /*Connect last visited node with current node */
        if (pre != null){
            pre.next = head;
            head.prev = pre;
        }
        pre = head;

        // Store head.next in a next pointer in case recursive call to flatten head.child overrides head.next
        Node next = head.next;

        flatten(head.child);
        head.child = null;

        flatten(next);
        return head;
    }
}
