package com.practice.tree;

public class HeightBanancedTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);

		root.setLeft(new TreeNode(8));
		root.setRight(new TreeNode(22));
		root.getLeft().setLeft(new TreeNode(5));
		root.getLeft().setRight(new TreeNode(3));

		root.getRight().setLeft(new TreeNode(4));
		root.getRight().setRight(new TreeNode(25));

		root.getLeft().getRight().setLeft(new TreeNode(10));
		root.getLeft().getRight().setRight(new TreeNode(14));

		System.out.println("Tree is height balanced: " + checkHeightBalanacedUtil(root));

	}

	public static boolean checkHeightBalanacedUtil(TreeNode node) {

		return checkHeightBalanaced(node, new Height());
	}

	private static boolean checkHeightBalanaced(TreeNode node, Height height) {

		Height lh = new Height();
		Height rh = new Height();
		if (node == null) {
			height.height = -1;
			return true;
		}
		boolean lBal = checkHeightBalanaced(node.getLeft(), lh);
		boolean rBal = checkHeightBalanaced(node.getRight(), rh);
		height.height = Math.max(lh.height, rh.height) + 1;

		System.out.println("Height of node: "+ node.getData()+ " is "+height.height);
		return lBal && rBal && (Math.abs(lh.height - rh.height) <= 1);
	}
}
