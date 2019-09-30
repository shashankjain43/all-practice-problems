package com.practice.gfg.tree;

public class LongestConsecutiveSequenceInTree {

    public static void main(String[] args) {

        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        //printInorderTree(root);
        longestConsecutive(root);
    }

    static int longestConsecutive(Node root) {

        MaxLen maxLen = new MaxLen();
        int currLen = 1;

        findLongestConsecutive(root, currLen, root.data, maxLen);
        return maxLen.maxLen > 1 ? maxLen.maxLen : -1;
        ;
    }

    private static void findLongestConsecutive(Node root, int currLen, int expectedData, MaxLen maxLen) {
        if (root == null) {
            return;
        }
        if (root.data == expectedData) {
            currLen++;
        } else {
            currLen = 1;
        }
        maxLen.maxLen = Math.max(maxLen.maxLen, currLen);
        findLongestConsecutive(root.left, currLen, root.data + 1, maxLen);
        findLongestConsecutive(root.right, currLen, root.data + 1, maxLen);

    }

    static class MaxLen {
        int maxLen = Integer.MIN_VALUE;
    }
}
