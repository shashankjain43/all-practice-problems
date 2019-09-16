package com.practice.tree;

public class DiameterOfTree {

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

		System.out.println("Diameter is : " + getTreeDimeterUtil(root));
	}

	private static int getTreeDimeterUtil(TreeNode root) {
		int dia = getDiameter(root, new Height());
		return dia;
	}

	private static int getDiameter(TreeNode root, Height height) {
		Height lHeight = new Height();
		Height rHeight = new Height();
		if (root == null) {
			height.height = 0;
			return 0;
		}
		int lDia = getDiameter(root.getLeft(), lHeight);
		int rDia = getDiameter(root.getRight(), rHeight);
		height.height = Math.max(lHeight.height, rHeight.height) + 1;
		return Math.max(Math.max(lDia, rDia), lHeight.height + rHeight.height + 1);
	}

}

class Height {

	int height;

	public Height(int i) {
		this.height = i;
	}

	public Height() {
	}

}
