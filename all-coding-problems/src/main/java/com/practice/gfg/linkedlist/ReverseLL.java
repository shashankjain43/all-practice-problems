package com.practice.gfg.linkedlist;

import com.practice.gfg.FastReader;

public class ReverseLL {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size = fr.nextInt();
            MyLinkedList myLL = new MyLinkedList();
            for (int j = 0; j < size; j++) {
                myLL.insertNode(fr.nextInt());
            }
            myLL.reverse();
            myLL.reverse();
            myLL.printLinkedList();
            System.out.println();
        }
    }


}
