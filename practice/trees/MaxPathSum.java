package com.practice.trees;


class MaxPathSum {

    static int maxPathSum(Node node) {

        Res res = new Res();
        res.val=Integer.MIN_VALUE;
        maxPath(node, res);
        return res.val;
    }

    static class Res {
        public int val;
    }

    private static int maxPath(Node node, Res res) {

        if (node == null)
            return 0;

        int leftSum = maxPath(node.left, res);
        int rightSum = maxPath(node.right, res);

        int maxSingle = Math.max(Math.max(leftSum, rightSum) + node.data, node.data);

        int maxTop = Math.max(maxSingle, leftSum + rightSum + node.data);

        res.val = Math.max(res.val, maxTop);

        return maxSingle;
    }

    public static void main(String args[]) {
        Node root = new Node(-15);
        root.left = new Node(5);
        root.right = new Node(6);
        root.left.left = new Node(-8);
        root.left.right = new Node(1);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(6);
        root.right.left = new Node(3);
        root.right.right = new Node(9);
        root.right.right.right = new Node(0);
        root.right.right.right.left = new Node(4);
        root.right.right.right.right = new Node(-1);
        root.right.right.right.right.left = new Node(10);
        System.out.println("Max pathSum " + maxPathSum(root)); // Result :  27
    }
}
