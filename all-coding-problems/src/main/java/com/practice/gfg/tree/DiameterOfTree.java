package com.practice.gfg.tree;

public class DiameterOfTree {

	public static void main(String[] args) {

		Node root = new Node(20);
		root.setLeft(new Node(8));
		root.setRight(new Node(22));
		root.getLeft().setLeft(new Node(5));
		root.getLeft().setRight(new Node(3));

		root.getRight().setLeft(new Node(4));
		root.getRight().setRight(new Node(25));

		root.getLeft().getRight().setLeft(new Node(10));
		root.getLeft().getRight().setRight(new Node(14));

		System.out.println("Diameter is : " + getTreeDimeterUtil(root));
	}

	private static int getTreeDimeterUtil(Node root) {
		int dia = getDiameter(root, new Height());
		return dia;
	}

	private static int getDiameter(Node root, Height height) {
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


