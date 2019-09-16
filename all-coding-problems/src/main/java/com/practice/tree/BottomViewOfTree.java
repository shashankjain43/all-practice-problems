package com.practice.tree;

import java.util.Map;
import java.util.TreeMap;

public class BottomViewOfTree {

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
        
		Map<Integer, Integer> lhm = new TreeMap<Integer, Integer>();
		int hDistance = 0;
		fillMapForBottomViewOfTree(root, lhm, hDistance);
		for(int i: lhm.keySet()) {
			System.out.println("Data is: "+lhm.get(i));
		}

	}

	private static void fillMapForBottomViewOfTree(TreeNode node, Map<Integer, Integer> lhm, int hDistance) {
		
		lhm.put(hDistance, node.getData());
		
		if(node.getLeft()!=null) {
			fillMapForBottomViewOfTree(node.getLeft(), lhm, hDistance-1);
		}
		
		if(node.getRight()!=null) {
			fillMapForBottomViewOfTree(node.getRight(), lhm, hDistance+1);
		}
		
	}

}
