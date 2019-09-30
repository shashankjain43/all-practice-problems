package com.practice.gfg.tree;

public class DiameterOfBinaryTree {

  static class MaxLengthPath {
    int maxLength = Integer.MIN_VALUE;
  }

  public static void main(String[] args) {
    Node root = new Node(-3);
    root.setLeft(new Node(2));
    root.setRight(new Node(2));
    root.getLeft().setLeft(new Node(3));
    root.getLeft().setRight(new Node(4));
    root.getRight().setLeft(new Node(4));
    root.right.left.left = new Node(10);
    root.right.left.left.left = new Node(10);
    root.right.left.left.left.right = new Node(10);
    root.getRight().setRight(new Node(8));
    root.right.right.right = new Node(10);
    root.right.right.right.right = new Node(10);
    root.right.right.right.right.right = new Node(10);

    MaxLengthPath maxLengthPath = new MaxLengthPath();
    findDiameterOfBinaryTree(root, maxLengthPath);
    System.out.println(maxLengthPath.maxLength);
  }

  private static int findDiameterOfBinaryTree(Node root, MaxLengthPath maxLengthPath) {
    if (root == null) {
      return 0;
    }
    int lCount = findDiameterOfBinaryTree(root.left, maxLengthPath);
    int rCount = findDiameterOfBinaryTree(root.right, maxLengthPath);
    int currCount = 1 + Math.max(lCount, rCount);
    if (maxLengthPath.maxLength < 1 + lCount + rCount) {
      maxLengthPath.maxLength = 1 + lCount + rCount;
    }
    return currCount;
  }
}