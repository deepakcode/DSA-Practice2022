package com.practice.trees;

public class isTreesSymmetric {
    // 1. check only node to node

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(1);

        boolean isIdentical = symmetric(root);
        System.out.println("IsIdentical "+isIdentical);
    }

    private static boolean symmetric(Node root) {
        if(root==null)
            return true;

        return isIdentical(root.left,root.right);
    }

    static boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 != null && root2!= null)
            return
                    root1.data == root2.data
                            && isIdentical(root1.left, root2.left)
                            && isIdentical(root1.right, root2.right);
        return false;
    }
}
