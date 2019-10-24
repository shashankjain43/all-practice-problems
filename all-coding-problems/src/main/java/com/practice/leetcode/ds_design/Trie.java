package com.practice.leetcode.ds_design;

public class Trie {

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word != null) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                if (!node.hasChar(word.charAt(i))) {
                    node.putChar(word.charAt(i));
                }
                node = node.getNodeAtChar(word.charAt(i));
            }
            node.markEnd();
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = root;
        int i = 0;
        while (i < word.length() && node.hasChar(word.charAt(i))) {
            node = node.getNodeAtChar(word.charAt(i));
            i++;
        }
        return i == word.length() && node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        int i = 0;
        while (i < prefix.length() && node.hasChar(prefix.charAt(i))) {
            node = node.getNodeAtChar(prefix.charAt(i));
            i++;
        }
        return i == prefix.length();


    }

    class TrieNode {

        private boolean isEnd;
        private final int R = 26;
        private TrieNode[] links;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public char getFirstChildChar() {
            Character firstChild = null;
            for (int i = 0; i < R && firstChild == null; i++) {
                if (links[i] != null) {
                    firstChild = (char) ('a' + i);
                }
            }
            return firstChild;
        }

        public boolean isEnd() {

            return isEnd;
        }

        public int getChildCount() {
            int childCount = 0;
            for (int i = 0; i < R; i++) {
                if (links[i] != null) {
                    childCount++;
                }
            }
            return childCount;
        }

        public void markEnd() {
            isEnd = true;
        }

        public TrieNode getNodeAtChar(char charAt) {
            return links[charAt - 'a'];
        }

        public void putChar(char alpha) {
            if (links[alpha - 'a'] == null) {
                links[alpha - 'a'] = new TrieNode();
            }
        }

        public boolean hasChar(char c) {
            return links[c - 'a'] != null;
        }

    }
}
