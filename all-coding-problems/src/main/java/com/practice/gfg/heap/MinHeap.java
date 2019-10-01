package com.practice.gfg.heap;

public class MinHeap {

    int[] harr;
    int capacity;
    int heap_size;

    MinHeap(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int left(int i) {
        return (2 * i + 1);
    }

    int right(int i) {
        return (2 * i + 2);
    }

    // You need to write code for below three functions
    int extractMin() {
        if(heap_size > 0){
            int min = harr[0];
            deleteKey(0);
            return min;
        }
        return -1;
    }

    void insertKey(int k) {
        if (heap_size < capacity) {
            heap_size = heap_size + 1;
            harr[heap_size - 1] = k;
            minHeapifyUp(heap_size - 1);
        }
    }

    private void minHeapifyUp(int i) {
        int parent = parent(i);
        while (i >= 0 && harr[parent] > harr[i]) {
            int temp = harr[i];
            harr[i] = harr[parent];
            harr[parent] = temp;
            i = parent;
        }
    }

    void deleteKey(int i) {
        if (i < heap_size) {
            harr[i] = harr[heap_size - 1];
            --heap_size;
            minHeapify(i);
        }
    }

    /* You may call below minHeapify function in
      above codes. Please do not delete this code
      if you are not writing your own minHeapify */
    void minHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l] < harr[i])
            smallest = l;
        if (r < heap_size && harr[r] < harr[smallest])
            smallest = r;
        if (smallest != i) {
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            minHeapify(smallest);
        }
    }

}
