package com.practice.gfg.tree;

import java.util.Map;
import java.util.TreeMap;

public class BottomViewOfTree {

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
        
		Map<Integer, Integer> lhm = new TreeMap<Integer, Integer>();
		int hDistance = 0;
		fillMapForBottomViewOfTree(root, lhm, hDistance);
		for(int i: lhm.keySet()) {
			System.out.println("Data is: "+lhm.get(i));
		}

	}

	private static void fillMapForBottomViewOfTree(Node node, Map<Integer, Integer> lhm, int hDistance) {
		
		lhm.put(hDistance, node.getData());
		
		if(node.getLeft()!=null) {
			fillMapForBottomViewOfTree(node.getLeft(), lhm, hDistance-1);
		}
		
		if(node.getRight()!=null) {
			fillMapForBottomViewOfTree(node.getRight(), lhm, hDistance+1);
		}
		
	}

}
