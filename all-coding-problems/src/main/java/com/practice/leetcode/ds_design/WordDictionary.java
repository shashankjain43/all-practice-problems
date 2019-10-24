package com.practice.leetcode.ds_design;

public class WordDictionary {

    Trie trie;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        trie = new Trie();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        trie.insert(word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return trie.search(word, trie.root);
    }

    class Trie {

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

        public boolean search(String word, TrieNode root) {
            TrieNode node = root;
            int i = 0;
            while (i < word.length()) {
                char ch = word.charAt(i);
                if (ch == '.') {
                    boolean result = false;
                    for (int j = 0; j < 26; j++) {
                        if (node.links[j] != null) {
                            result = search(word.substring(i + 1), node.links[j]);
                        }
                        if (result) {
                            return result;
                        }
                    }
                    return false;
                }
                if (node.hasChar(word.charAt(i))) {
                    node = node.getNodeAtChar(word.charAt(i));
                } else {
                    return false;
                }
                i++;
            }
            return i == word.length() && node.isEnd;
        }

        class TrieNode {

            private boolean isEnd;
            private final int R = 26;
            private TrieNode[] links;

            public TrieNode() {
                links = new TrieNode[R];
            }

            public boolean isEnd() {

                return isEnd;
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
}
