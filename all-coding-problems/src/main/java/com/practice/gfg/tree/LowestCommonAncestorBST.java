package com.practice.gfg.tree;

public class LowestCommonAncestorBST {

    public static void main(String[] args) {

        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        int n1 = 8;
        int n2 = 9;
        System.out.println("LCA is: "+findLowestCommonAncestorBST(root, n1, n2).data);
    }

    private static Node findLowestCommonAncestorBST(Node root, int n1, int n2) {

        if (root.data > n1 && root.data < n2 || root.data == n1 || root.data == n2) {
            return root;
        } else if (root.data < n1 && root.data < n2 && root.right != null) {
            return findLowestCommonAncestorBST(root.right, n1, n2);
        } else if (root.data > n1 && root.data > n2 && root.left != null) {
            return findLowestCommonAncestorBST(root.left, n1, n2);
        }
        return root;
    }

}
