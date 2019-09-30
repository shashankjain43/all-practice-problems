package com.practice.gfg.tree;

public class ConvertToMirrorTree {
    public static void main(String[] args) {

        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        printInorderTree(root);
        convertToMirrorTree(root);
        System.out.println();
        printInorderTree(root);
    }

    private static void printInorderTree(Node root) {
        if(root!=null){
            printInorderTree(root.left);
            System.out.print(root.data+" ");
            printInorderTree(root.right);
        }
    }

    private static void convertToMirrorTree(Node root) {

        if(root!=null){
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
            convertToMirrorTree(root.left);
            convertToMirrorTree(root.right);
        }


    }

}
