package com.practice.gfg.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversal {
	static class TreeNode {
		public int data;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(20);
		root.right = new TreeNode(30);

		root.left.left = new TreeNode(16);
		root.left.right = new TreeNode(40);
		root.right.left = new TreeNode(42);
		root.right.right = new TreeNode(25);

		root.left.left.left = new TreeNode(17);
		root.left.left.right = new TreeNode(18);
		root.left.right.left = new TreeNode(50);
		root.left.right.right = new TreeNode(52);

		root.right.right.left = new TreeNode(55);
		root.right.right.right = new TreeNode(60);

		zigZagTraversal(root);
		System.out.println();
		zigZagTraversalTwoStack(root);

	}

	private static void zigZagTraversal(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(new TreeNode(-1));
		TreeNode prev = null;
		int level = 0;
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(root);
		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			if (prev != null && prev.data == -1 && curr.data == -1) {
				break;
			}
			if (curr.data == -1) {
				queue.add(new TreeNode(-1));
				if (!stack.isEmpty()) {
					printAndClearStack(stack);
				}
				level++;
			} else {
				// for odd level
				if (level % 2 != 0) {
					System.out.print(curr.data + " ");
					if(curr.left != null) {
						stack.push(curr.left);
					}
					if(curr.right != null) {
						stack.push(curr.right);
					}
				}
				if(curr.left != null) {
					queue.add(curr.left);
				}
				if(curr.right != null) {
					queue.add(curr.right);
				}
			}
			prev = curr;
		}
	}
	
	private static void zigZagTraversalTwoStack(TreeNode root) {

		Deque<TreeNode> leftToRightStack = new LinkedList<TreeNode>();
		Deque<TreeNode> rightToLeftStack = new LinkedList<TreeNode>();
		leftToRightStack.push(root);
		boolean leftToRight = true;
		while (!leftToRightStack.isEmpty() || !rightToLeftStack.isEmpty()) {
			if(leftToRight) {
				while(!leftToRightStack.isEmpty()) {
					TreeNode node = leftToRightStack.pop();
					System.out.print(node.data+" ");
					if(node.left != null) {
						rightToLeftStack.push(node.left);
					}
					if(node.right != null) {
						rightToLeftStack.push(node.right);
					}
				}
				leftToRight = false;
			} else {
				while(!rightToLeftStack.isEmpty()) {
					TreeNode node = rightToLeftStack.pop();
					System.out.print(node.data+" ");
					if(node.right != null) {
						leftToRightStack.push(node.right);
					}
					if(node.left != null) {
						leftToRightStack.push(node.left);
					}
				}
				leftToRight = true;
			}
		}
	}

	private static void printAndClearStack(Deque<TreeNode> stack) {
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().data + " ");
		}

	}

}
