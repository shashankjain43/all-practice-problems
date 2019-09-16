package com.practice.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LinkVerticalNode {

	static class VerticalTreeNode {
		public VerticalTreeNode left;
		public VerticalTreeNode right;
		public VerticalTreeNode vertical;
		public int data;
		public VerticalTreeNode(int data) {
			super();
			this.data = data;
		}
		
		@Override
		public String toString() {
			return ""+data;
		}
	}

	public static void main(String[] args) {
		VerticalTreeNode root = new VerticalTreeNode(20);
        root.left = new VerticalTreeNode(8); 
        root.right = new VerticalTreeNode(22);
        root.left.left=new VerticalTreeNode(5);
        root.left.right=new VerticalTreeNode(3);
        
        root.right.left=new VerticalTreeNode(4);
        root.right.right=new VerticalTreeNode(25);
        
        root.right.left.left=new VerticalTreeNode(10);
        root.right.left.right=new VerticalTreeNode(14);
		Map<Integer, List<VerticalTreeNode>> map = new HashMap<Integer, List<VerticalTreeNode>>();
		fillMap(root, map, 0);
		linkVerticalPointers(map);
		System.out.println(map.toString());
	}

	private static void linkVerticalPointers(Map<Integer, List<VerticalTreeNode>> map) {
		for (int i : map.keySet()) {
			List<VerticalTreeNode> list = map.get(i);
			VerticalTreeNode first = list.get(0);
			VerticalTreeNode prev = first;
			for (int j = 1; j < list.size(); j++) {
				VerticalTreeNode next = list.get(j);
				prev.vertical = next;
				prev = next;
			}
			prev.vertical = null;
		}
	}

	private static void fillMap(VerticalTreeNode root, Map<Integer, List<VerticalTreeNode>> map, int dist) {
		if (root == null) {
			return;
		}
		List<VerticalTreeNode> list = map.get(dist);
		if (list == null) {
			list = new LinkedList<VerticalTreeNode>();
		}
		list.add(root);
		map.put(dist, list);
		System.out.println(list.toString());
		fillMap(root.left, map, dist - 1);
		fillMap(root.right, map, dist + 1);
	}

}
