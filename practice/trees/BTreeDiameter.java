package com.practice.trees;

class Res {
    public int val;
}

public class BTreeDiameter {

    private static int getDiameter(Node root) {

        if (root == null)
            return 0;

        int leftDiameter = getDiameter(root.left);
        int rightDiameter = getDiameter(root.right);

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int maxDiameter = Math.max(leftDiameter, rightDiameter);
        int nodeDiameter = leftHeight + rightHeight + 1;

        return Math.max(nodeDiameter, maxDiameter);
    }

    private static int height(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println("The diameter : " + getDiameter(root));
    }
}
