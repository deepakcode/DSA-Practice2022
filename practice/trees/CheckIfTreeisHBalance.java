package com.practice.trees;

public class CheckIfTreeisHBalance {

    private static boolean isHBalance(Node node) {
        if(node==null)
            return true;

        int diff = height(node.left)-height(node.right);

        if(Math.abs(diff)<=1 &&  isHBalance(node.left) && isHBalance(node.right))
            return true;
        else
            return false;
    }

    private static int height(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.right = new Node(2);
        root.left = new Node(4);
        root.left.left = new Node(5);
        System.out.println("The diameter : " + isHBalance(root));
    }
}
