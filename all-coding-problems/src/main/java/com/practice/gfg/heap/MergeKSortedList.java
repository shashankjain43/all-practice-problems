package com.practice.gfg.heap;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedList {

    Node mergeKList(Node[] arr, int size) {
        Node prev = null;
        Queue<Node> minHeap = new PriorityQueue<Node>((o1, o2) -> o1.value - o2.value);
        Arrays.stream(arr).forEach(minHeap::offer);
        Node head = minHeap.peek();
        while (!minHeap.isEmpty()) {
            Node curr = minHeap.poll();
            if (curr.next != null) {
                minHeap.add(curr.next);
            }
            if (prev != null) {
                prev.next = curr;
            }
            prev = curr;
        }
        return head;
    }
}
