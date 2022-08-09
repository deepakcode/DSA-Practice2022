package com.practice.trees;

public class isTreesIdenticle {
    // 1. check only node to node

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);

        boolean isIdentical = isIdentical(root1,root2);
        System.out.println("IsIdentical "+isIdentical);
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
