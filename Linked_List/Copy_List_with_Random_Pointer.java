// https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1229/
package Linked_List;

import java.util.HashMap;

public class Copy_List_with_Random_Pointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head == null) return null;

        HashMap<Node,Node> map = new HashMap<>();
        Node temp = head;

        while (temp != null){
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;

        while (temp != null){
            Node newTempNode = map.get(temp);
            newTempNode.next = map.get(temp.next);
            newTempNode.random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }
}
