package com.practice.gfg.tree;

public class IdenticalTree {

	public static void main(String[] args) {

		TreeNode root1 = new TreeNode(20);
		root1.setLeft(new TreeNode(8));
		root1.setRight(new TreeNode(22));
		root1.getLeft().setLeft(new TreeNode(5));
		root1.getLeft().setRight(new TreeNode(3));

		root1.getRight().setLeft(new TreeNode(4));
		root1.getRight().setRight(new TreeNode(25));

		root1.getLeft().getRight().setLeft(new TreeNode(10));
		root1.getLeft().getRight().setRight(new TreeNode(14));

		TreeNode root2 = new TreeNode(20);
		root2.setLeft(new TreeNode(8));
		root2.setRight(new TreeNode(22));
		root2.getLeft().setLeft(new TreeNode(5));
		root2.getLeft().setRight(new TreeNode(3));

		root2.getRight().setLeft(new TreeNode(4));
		root2.getRight().setRight(new TreeNode(25));

		root2.getLeft().getRight().setLeft(new TreeNode(10));
		root2.getLeft().getRight().setRight(new TreeNode(14));

		System.out.println("If Identical?: " + checkIdentical(root1, root2));

	}

	private static boolean checkIdentical(TreeNode root1, TreeNode root2) {
		return checkIdenticalUtil(root1, root2);
	}

	private static boolean checkIdenticalUtil(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		return root1 != null && root2 != null && root1.getData() == root2.getData()
				&& checkIdenticalUtil(root1.getLeft(), root2.getLeft())
				&& checkIdenticalUtil(root1.getRight(), root2.getRight());
	}
}
