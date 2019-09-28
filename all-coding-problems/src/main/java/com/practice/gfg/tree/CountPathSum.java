package com.practice.gfg.tree;

public class CountPathSum {

	public static void main(String[] args) {
		
		Node root = new Node(20);
		root.setLeft(new Node(8));
		root.setRight(new Node(22));
		root.getLeft().setLeft(new Node(5));
		root.getLeft().setRight(new Node(3));
		
		root.getLeft().left.left = new Node(8);

		root.getRight().setLeft(new Node(4));
		root.getRight().setRight(new Node(25));

		root.getLeft().getRight().setLeft(new Node(10));
		root.getLeft().getRight().setRight(new Node(14));
		
		System.out.println("count: "+ getTotalCount(root, 46));

	}
	
	static class Info{
	    int currSum;
	    int count;

	}

	static int getTotalCount(Node root, int sum){
	    Info info = new Info();
	    info.currSum = 0;
	    info.count = 0;
	    getCountSumUtil(root, sum, info);
	    return info.count;
	}

	static void getCountSumUtil(Node root, int sum, Info info){
		
	    if(root == null){
	        return;
	    }
	    if(root.left == null && root.right == null){
	        if(info.currSum + root.data == sum){
	            info.count = info.count + 1;
	        }
	        return;
	    }
	    info.currSum = info.currSum + root.data;
	    getCountSumUtil(root.left, sum, info);
	    getCountSumUtil(root.right, sum, info);
	    info.currSum = info.currSum - root.data;
	}

}
