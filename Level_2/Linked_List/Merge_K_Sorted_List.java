// https://www.youtube.com/watch?v=wugaUVZ8PVw&list=PL-Jc9J83PIiGRqcfZxxgOKovgLVd3znnq&index=7

package Level_2.Linked_List;

import java.util.Scanner;

public class Merge_K_Sorted_List {  // O(N K lgK)
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode c1 = list1;
        ListNode c2 = list2;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while (c1 != null && c2 != null){
            if (c1.val < c2.val){
                prev.next = c1;
                c1 = c1.next;
            } else {
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }
        prev.next = c1 != null ? c1 : c2;
        return dummy.next;
    }
    public static ListNode mergeKLists(ListNode[] lists, int si, int ei) {
        if (si > ei) return null;
        if (si == ei) return lists[si];

        int mid = (si + ei) / 2;

        ListNode l1 = mergeKLists(lists, si, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, ei);

        return mergeTwoLists(l1, l2);
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return mergeKLists(lists, 0, lists.length - 1);
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
