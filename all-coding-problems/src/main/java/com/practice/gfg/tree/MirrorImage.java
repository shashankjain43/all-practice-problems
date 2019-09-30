package com.practice.gfg.tree;

public class MirrorImage {
    public static void main(String[] args) {

        Node root1 = new Node(1);
        root1.setLeft(new Node(2));
        root1.setRight(new Node(2));
        root1.getLeft().setLeft(new Node(3));
        root1.getLeft().setRight(new Node(4));
        root1.getRight().setLeft(new Node(4));
        root1.getRight().setRight(new Node(3));
        System.out.println("If Mirror Image?: " + checkIfMirrorImage(root1.left, root1.right));
    }

    private static boolean checkIfMirrorImage(Node left, Node right) {

        if (left == null && right == null) {
            return true;
        }
        return left != null && right != null
                && left.data == right.data
                && checkIfMirrorImage(left.left, right.right)
                && checkIfMirrorImage(left.right, right.left);
    }

}
