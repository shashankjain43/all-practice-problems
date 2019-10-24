package com.practice.leetcode.ds_design;

import java.util.Deque;
import java.util.LinkedList;

public class BSTIterator {

    Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        fillStackLeftSkewed(root);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            fillStackLeftSkewed(node.right);
        }
        return node.val;
    }

    private void fillStackLeftSkewed(TreeNode root) {
        if (root == null) {
            return;
        }
        stack.push(root);
        fillStackLeftSkewed(root.left);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
