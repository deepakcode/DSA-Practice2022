package com.practice.trees;

public class leafNodeCount {

    public static void main(String[] args) {

        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        System.out.println("Sum "+ countleafNodes(root));
        
    }

    private static int countleafNodes(Node node) {

        if(node==null)
            return 0;
        if(node.left==null && node.right==null)
            return 1;
        else
            return countleafNodes(node.left)+countleafNodes(node.right);
    }
}
