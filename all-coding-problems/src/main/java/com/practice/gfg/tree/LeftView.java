package com.practice.gfg.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftView {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        printLeftView(root);
    }

    private static void printLeftView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(new TreeNode(-1));
        queue.offer(root);
        TreeNode prev = null;
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            if (currNode.data != -1) {
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            } else if (!queue.isEmpty()) {
                queue.offer(new TreeNode(-1));
            }
            if (prev != null && prev.data == -1) {
                System.out.print(currNode.data + " ");
            }
            prev = currNode;
        }
    }
}
