package com.practice.gfg.tree;

public class LCA_SimpleBinaryTree {
    public static void main(String[] args) {

        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        System.out.println(lca(root, 2, 4).data);
    }

    private static Node lca(Node root, int n1, int n2) {

        if (root == null) {
            return null;
        }

        if (root.data == n1 || root.data == n2)
            return root;
        /*if ((ifExists(root.left, n1) && ifExists(root.right, n2)) || (ifExists(root.left, n2) && ifExists(root.right, n1))) {
            return root;
        }*/
        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        } else {
            return left;
        }
    }

    private static boolean ifExists(Node root, int n1) {
        if (root == null) {
            return false;
        }
        return n1 == root.data || ifExists(root.left, n1) || ifExists(root.right, n1);
    }

}
