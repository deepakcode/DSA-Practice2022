package com.practice.trees;

/**
 *        4
 *   2         6
 * 1    3    5    7
 *
 *
 * s1, s2
 *
 */
public class LowestCommonAnce {

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        Node node= lca(root, 5,7);
        System.out.println("LCA : "+node.data);
    }

    private static Node lca(Node node,int p1, int p2 ) {

        if(node==null)
            return node;

        if(node.data==p1 || node.data==p2)
            return node;

        Node left = lca(node.left,p1,p2);
        Node right = lca(node.right,p1,p2);

        if(left==null)
            return right;

        if(right==null)
            return left;
        else
            return node;
    }
    static class  Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
}