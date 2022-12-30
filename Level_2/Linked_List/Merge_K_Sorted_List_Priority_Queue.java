// https://www.youtube.com/watch?v=wugaUVZ8PVw&list=PL-Jc9J83PIiGRqcfZxxgOKovgLVd3znnq&index=7

package Level_2.Linked_List;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Merge_K_Sorted_List_Priority_Queue {   // O(N K lgK)
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->{
            return a.val - b.val;       // this - other (default)(min)
        });

        for (ListNode l : lists)
            if (l != null)
                pq.add(l);

        ListNode dummy  = new ListNode(-1);
        ListNode prev = dummy;
        while (pq.isEmpty()){
            ListNode node = pq.remove();

            prev.next = node;
            prev = prev.next;
            node = node.next;

            if (node != null)
                pq.add(node);
        }
        return dummy.next;
    }

    public static Scanner scn = new Scanner(System.in);
    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode[] list = new ListNode[n];
        for (int i = 0; i < n; i++) {
            int m = scn.nextInt();
            list[i] = createList(m);
        }

        ListNode head = mergeKLists(list);
        printList(head);
    }
}
