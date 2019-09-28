package com.practice.gfg.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftView {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        printLeftView(root);
    }

    private static void printLeftView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(-1));
        queue.offer(root);
        Node prev = null;
        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            if (currNode.data != -1) {
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            } else if (!queue.isEmpty()) {
                queue.offer(new Node(-1));
            }
            if (prev != null && prev.data == -1) {
                System.out.print(currNode.data + " ");
            }
            prev = currNode;
        }
    }
}
