package com.practice.gfg.linkedlist;

public class MyLinkedList {

    public Node head;
    public Node last;


    public MyLinkedList() {
        this.head = null;
    }

    public void insertNode(int nodeData) {
        Node node = new Node(nodeData);
        if (this.head != null) {
            node.next = head;
        }
        this.head = node;
    }

    public void printLinkedList(){
        Node node = head;
        while (node != null) {
            System.out.print(node.value+ " ");
            node = node.next;
        }
    }

    public void reverse(){
        head = reverse(head);
    }

    private Node reverse(Node head) {
        if(head == null) {
            return head;
        }
        if(head.next == null) {
            return head;
        }
        Node newHeadNode = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHeadNode;
    }
}
