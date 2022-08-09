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


public class SpiralTraversal_p01 {

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        spiralTraversal(root);
        System.out.println("\n---diagonal print----");
    }

    private static void spiralTraversal(Node root) {
        int h = getTreeHeight(root);
        boolean rightToLeft=false;
        for (int level = 1; level <=h; level++) {
            printLevel(root,level,rightToLeft);
            rightToLeft=!rightToLeft;
            System.out.print("\n");
        }
    }

    private static void printLevel(Node root, int level, boolean rightToLeft) {
        if(level==0)
            return;
        if(level==1)
            System.out.print(root.data+" ");
        else
        {
            if(rightToLeft){
                printLevel(root.left,level-1,rightToLeft);
                printLevel(root.right,level-1,rightToLeft);
            }else {
                printLevel(root.right,level-1,rightToLeft);
                printLevel(root.left,level-1,rightToLeft);
            }
        }
    }

    static int getTreeHeight(Node root){
        if(root==null)
            return 0;
        else
            return 1 + Math.max(getTreeHeight(root.left),getTreeHeight(root.right));
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
