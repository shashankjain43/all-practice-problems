package com.practice.gfg.tree;

public class HeightBanancedTree {

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

		System.out.println("Tree is height balanced: " + checkHeightBalanacedUtil(root));

	}

	public static boolean checkHeightBalanacedUtil(Node node) {

		return checkHeightBalanaced(node, new Height());
	}

	private static boolean checkHeightBalanaced(Node node, Height height) {

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
