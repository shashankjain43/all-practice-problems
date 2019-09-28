package com.practice.gfg.tree;

public class CheckForBST {

    public static void main(String[] args) {

        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        checkForBST(root);
    }

    private static void checkForBST(Node root) {

        System.out.println(!checkForBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 0 : 1);
    }

    private static boolean checkForBSTUtil(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        return  root.data > min && root.data < max
                && checkForBSTUtil(root.left, min, root.data )
                && checkForBSTUtil(root.right, root.data, max);
    }
}
