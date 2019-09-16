package com.practice.tree;

public class CountPathSum {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(20);
		root.setLeft(new TreeNode(8));
		root.setRight(new TreeNode(22));
		root.getLeft().setLeft(new TreeNode(5));
		root.getLeft().setRight(new TreeNode(3));
		
		root.getLeft().left.left = new TreeNode(8);

		root.getRight().setLeft(new TreeNode(4));
		root.getRight().setRight(new TreeNode(25));

		root.getLeft().getRight().setLeft(new TreeNode(10));
		root.getLeft().getRight().setRight(new TreeNode(14));
		
		System.out.println("count: "+ getTotalCount(root, 46));

	}
	
	static class Info{
	    int currSum;
	    int count;

	}

	static int getTotalCount(TreeNode root, int sum){
	    Info info = new Info();
	    info.currSum = 0;
	    info.count = 0;
	    getCountSumUtil(root, sum, info);
	    return info.count;
	}

	static void getCountSumUtil(TreeNode root, int sum, Info info){
		
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
