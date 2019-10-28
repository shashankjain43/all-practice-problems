package com.practice.leetcode.tree;

public class MaxPathSum {

    /**
     * Given a non-empty binary tree, find the maximum path sum.
     *
     * For this problem, a path is defined as any sequence of nodes from
     * some starting node to any node in the tree along the parent-child connections.
     * The path must contain at least one node and does not need to go through the root.
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        Sum sum = new Sum();
        maxPathSumUtil(root, sum);
        return sum.maxSum;

    }

    private int maxPathSumUtil(TreeNode root, Sum sum) {
        if (root == null) {
            return 0;
        }
        int lSum = Math.max(maxPathSumUtil(root.left, sum), 0);
        int rSum = Math.max(maxPathSumUtil(root.right, sum), 0);
        sum.maxSum = Math.max(lSum + rSum + root.val, sum.maxSum);
        return Math.max(lSum, rSum) + root.val;
    }

    class Sum {
        int maxSum = Integer.MIN_VALUE;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
