package com.practice.gfg.tree;

public class IdenticalTree {

	public static void main(String[] args) {

		Node root1 = new Node(20);
		root1.setLeft(new Node(8));
		root1.setRight(new Node(22));
		root1.getLeft().setLeft(new Node(5));
		root1.getLeft().setRight(new Node(3));

		root1.getRight().setLeft(new Node(4));
		root1.getRight().setRight(new Node(25));

		root1.getLeft().getRight().setLeft(new Node(10));
		root1.getLeft().getRight().setRight(new Node(14));

		Node root2 = new Node(20);
		root2.setLeft(new Node(8));
		root2.setRight(new Node(22));
		root2.getLeft().setLeft(new Node(5));
		root2.getLeft().setRight(new Node(3));

		root2.getRight().setLeft(new Node(4));
		root2.getRight().setRight(new Node(25));

		root2.getLeft().getRight().setLeft(new Node(10));
		root2.getLeft().getRight().setRight(new Node(14));

		System.out.println("If Identical?: " + checkIdentical(root1, root2));

	}

	private static boolean checkIdentical(Node root1, Node root2) {
		return checkIdenticalUtil(root1, root2);
	}

	private static boolean checkIdenticalUtil(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		return root1 != null && root2 != null && root1.getData() == root2.getData()
				&& checkIdenticalUtil(root1.getLeft(), root2.getLeft())
				&& checkIdenticalUtil(root1.getRight(), root2.getRight());
	}
}
