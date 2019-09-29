package com.practice.gfg.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {
    public static void main(String[] args) {

        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        connectNodesAtSameLevel(root);
    }

    private static void connectNodesAtSameLevel(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(new Node(-1));
        Node prev = root;
        while (!queue.isEmpty()){
            Node currNode = queue.poll();
            if(currNode.data == -1){
                prev.nextRight = null;
                System.out.println("Connecting Node: "+prev.data+" to Node: "+ null);
                if(!queue.isEmpty()){
                    queue.offer(new Node(-1));
                }
            } else {
                if(prev.data != -1){
                    prev.nextRight = currNode;
                    System.out.println("Connecting Node: "+prev.data+" to Node: "+ currNode.data);
                }
                if(currNode.left!=null){
                    queue.offer(currNode.left);
                }
                if(currNode.right!=null){
                    queue.offer(currNode.right);
                }
            }
            prev = currNode;
        }
    }
}
