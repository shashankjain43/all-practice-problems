package com.practice.gfg.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrder {
    public static void main(String[] args) {

        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        printVerticalOrder(root);
    }

    private static void printVerticalOrder(Node root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        printVerticalOrderUtil(root, map, 0);
        map.forEach((integer, integers) -> integers.forEach(integer1 -> System.out.print(integer1+" ")));
        //map.values().stream().collect(Collectors.toList());
    }

    private static void printVerticalOrderUtil(Node root, Map<Integer, List<Integer>> map, int i) {
        if (root != null) {
            List<Integer> list = map.get(i);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(root.data);
            map.put(i, list);
            printVerticalOrderUtil(root.left, map, i - 1);
            printVerticalOrderUtil(root.right, map, i + 1);
        }
    }

}
