package com.practice.gfg.tree;

public class CalculateHeight {
    public static void main(String[] args) {

        Node root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(2));
        root.getLeft().setLeft(new Node(3));
        root.getLeft().setRight(new Node(4));
        root.getRight().setLeft(new Node(4));
        root.getRight().setRight(new Node(3));
        System.out.println(calculateHeight(root));
    }

    private static int calculateHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(calculateHeight(root.left), calculateHeight(root.right));
    }

}
