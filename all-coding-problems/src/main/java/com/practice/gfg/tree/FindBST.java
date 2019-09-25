package com.practice.gfg.tree;

import java.util.List;

public class FindBST {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(50);
		root.setLeft(new TreeNode(30));
		root.setRight(new TreeNode(60));
		root.getLeft().setLeft(new TreeNode(5));
		root.getLeft().setRight(new TreeNode(20));

		root.getRight().setLeft(new TreeNode(45));
		root.getRight().setRight(new TreeNode(70));

		root.getRight().getRight().setLeft(new TreeNode(65));
		root.getRight().getRight().setRight(new TreeNode(80));

		Info info = findBST(root);
		System.out.println("Largest BST is of size: " + info.largestBSTSize);
		System.out.println("root of Largest BST is: " + info.bstRoot);

	}

	static class Info {
		boolean isBST;
		int max;
		int min;
		int size;
		int largestBSTSize;
		TreeNode bstRoot;

		public Info(boolean isBST, int max, int min, int size, int largestBSTSize, TreeNode bstRoot) {
			super();
			this.isBST = isBST;
			this.max = max;
			this.min = min;
			this.size = size;
			this.largestBSTSize = largestBSTSize;
			this.bstRoot = bstRoot;
		}

		public Info() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Info [isBST=" + isBST + ", max=" + max + ", min=" + min + ", size=" + size + ", largestBSTSize="
					+ largestBSTSize + ", bstRoot=" + bstRoot + "]";
		}

	}

	public static Info findBST(TreeNode root) {

		if (root == null) {
			return new Info(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, null);
		}

		if (root.left == null && root.right == null) {
			return new Info(true, root.data, root.data, 1, 1, root);
		}

		Info lInfo = findBST(root.left);
		Info rInfo = findBST(root.right);

		Info currInfo = new Info();
		currInfo.max = Math.max(Math.max(lInfo.max, rInfo.max), root.data);
		currInfo.min = Math.min(Math.min(lInfo.min, rInfo.min), root.data);

		currInfo.size = lInfo.size + rInfo.size + 1;

		if (lInfo.isBST && rInfo.isBST && lInfo.max < root.data && root.data < rInfo.min) {
			currInfo.isBST = true;
			currInfo.largestBSTSize = lInfo.size + rInfo.size + 1;
			currInfo.bstRoot = root;
		} else {
			currInfo.largestBSTSize = Math.max(lInfo.largestBSTSize, rInfo.largestBSTSize);
			currInfo.bstRoot = lInfo.largestBSTSize > rInfo.largestBSTSize ? lInfo.bstRoot : rInfo.bstRoot;
			currInfo.isBST = false;
		}
		return currInfo;
	}
	
	public static long countSum(List<Integer> numbers) {

		int sum = 0;
		for (int n : numbers) {
			int res = 1;
			while (n % 2 == 0) {
				n = n / 2;
			}
			for (int i = 3; i <= Math.sqrt(n); i++) {
				int count = 0, curr_sum = 1;
				int curr_term = 1;
				while (n % i == 0) {
					count++;
					n = n / i;
					curr_term *= i;
					curr_sum += curr_term;
				}
				res *= curr_sum;
			}
			if (n >= 2) {
				res *= (1 + n);
			}
			sum = sum + res;
		}
		return sum;
	}
	
	

}
