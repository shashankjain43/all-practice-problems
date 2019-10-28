package com.practice.gfg.tree;

public class MaxPathSum {

  static class MaxSum {

    int maxSum = Integer.MIN_VALUE;
  }

  public static void main(String[] args) {
    Node root = new Node(-10);
    root.setLeft(new Node(2));
    root.setRight(new Node(-2));
    root.getLeft().setLeft(new Node(3));
    root.getLeft().setRight(new Node(4));
    root.getRight().setLeft(new Node(-4));
    root.getRight().setRight(new Node(10));

    MaxSum maxSum = new MaxSum();
    findMaxPathSum(root, maxSum);
    System.out.println(maxSum.maxSum);
  }

  private static int findMaxPathSum(Node root, MaxSum maxSum) {
    if (root == null) {
      return 0;
    }
    int lSum = findMaxPathSum(root.left, maxSum);
    int rSum = findMaxPathSum(root.right, maxSum);
    int currSum = root.data + Math.max(lSum, rSum);
    if (maxSum.maxSum < root.data + lSum + rSum) {
      maxSum.maxSum = root.data + lSum + rSum;
    }
    return currSum;
  }
}