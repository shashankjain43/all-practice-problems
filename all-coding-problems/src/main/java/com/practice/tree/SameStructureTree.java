package com.practice.tree;

public class SameStructureTree {

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
		root2.setLeft(new TreeNode(20));
		root2.setRight(new TreeNode(22));
		root2.getLeft().setLeft(new TreeNode(5));
		root2.getLeft().setRight(new TreeNode(31));

		root2.getRight().setLeft(new TreeNode(4));
		root2.getRight().setRight(new TreeNode(25));

		root2.getLeft().getRight().setLeft(new TreeNode(10));
		//root2.getLeft().getRight().setRight(new TreeNode(14));

		System.out.println("If Same Structure?: " + checkIfSameStructure(root1, root2));

	}

	private static boolean checkIfSameStructure(TreeNode root1, TreeNode root2) {
		return checkIfSameStructureUtil(root1, root2);
	}

	private static boolean checkIfSameStructureUtil(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		return root1 != null && root2 != null && checkIfSameStructureUtil(root1.getLeft(), root2.getLeft())
				&& checkIfSameStructureUtil(root1.getRight(), root2.getRight());
	}

}