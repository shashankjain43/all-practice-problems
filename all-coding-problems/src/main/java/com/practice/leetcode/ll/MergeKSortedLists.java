package com.practice.leetcode.ll;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head = new ListNode(-1);
        ListNode curr = head;


        Queue<ListNode> minHeap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for (ListNode node : lists) {
            minHeap.add(node);
        }

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            if (node.next != null) {
                minHeap.add(node.next);
                node.next = null;
            }
            curr.next = node;
            curr = curr.next;
            printList(head.next);
            System.out.println();
        }
        return head.next;
    }

    private void printList(ListNode next) {
        while(next != null){
            System.out.print(next.val+ " ");
            next = next.next;
        }
    }
}
