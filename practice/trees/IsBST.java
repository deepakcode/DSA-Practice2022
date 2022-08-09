package com.practice.trees;


public class IsBST {

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        //System.out.println(isBSTCorrect(root));
        //System.out.println(isBSTOptimized(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(isBSTOptimizedSimplified(root, null, null));
    }

    //Incorrect method - Default method
    private static boolean isBST(Node root) {
        if (root == null)
            return true;
        if (root.left != null && root.data < root.left.data)
            return false;
        if (root.right != null && root.data > root.right.data)
            return false;
        if (!isBST(root.left) && !isBST(root.right))
            return false;
        return true;
    }

    //correct method - But not efficient
    private static boolean isBSTCorrect(Node root) {
        if (root == null)
            return true;
        if (root.left != null && root.data < root.left.data || maxOf(root.left) >= root.data)
            return false;
        if (root.right != null && root.data > root.right.data || minOf(root.right) <= root.data)
            return false;
        if (!isBST(root.left) || !isBST(root.right))
            return false;
        return true;
    }

    //correct method - efficient
    private static boolean isBSTOptimized(Node node, int min, int max) {
        if (node == null)
            return true;
        if (node.data < min || node.data > max)
            return false;
        return isBSTOptimized(node.left, min, node.data - 1) && isBSTOptimized(node.right, node.data + 1, max);
    }

    //correct method - efficient+ simplified
    private static boolean isBSTOptimizedSimplified(Node node, Node left, Node right) {
        if (node == null)
            return true;

        if (left != null && node.data < left.data)
            return false;

        if (right != null && node.data > right.data)
            return false;

        return isBSTOptimizedSimplified(node.left, left, node) &&
                isBSTOptimizedSimplified(node.right, node, right);
    }

    private static int maxOf(Node node) {
        if (node == null)
            return Integer.MIN_VALUE;
        return Math.max(node.data, Math.max(maxOf(node.left), maxOf(node.right)));
    }

    private static int minOf(Node node) {
        if (node == null)
            return Integer.MAX_VALUE;
        return Math.min(node.data, Math.min(minOf(node.left), minOf(node.right)));
    }
}
