package com.practice.gfg.array;

public class Trie {

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

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

	public String getLongestCommonPrefix() {
		TrieNode node = root;
		String prefix = null;
		while (node != null) {
			if (node.getChildCount() == 1 && !node.isEnd()) {
				prefix = prefix + node.getFirstChildChar();
				node = node.getNodeAtChar(node.getFirstChildChar());
			} else {
				node = null;
			}
		}
		return prefix;

	}
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