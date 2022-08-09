package com.practice.trees;

import java.util.*;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 1
 * 2         3
 * 4       5
 */
public class TreeTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("-----BFS --LeftView---");
        bfs(root);
        System.out.println("\n-----PreOrderStack---");
        dfsPreOrderUsingStack(root);
        System.out.println("\n-----Pre---");
        preOrder(root);
        System.out.println("\n-----Post---");
        postOrder(root);
        System.out.println("\n------InOrder--------");
        inOrder(root);
    }

    private static void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
            System.out.print(node.data + " ");
        }
    }

    private static void dfsPreOrderUsingStack(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node node = stack.pop();
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
            System.out.print(node.data + " ");
        }
    }

    private static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    private static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    private static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    private static int getHeight(Node root){
        if(root==null)
            return 0;
        return 1+Math.max(getHeight(root.left), getHeight(root.right));
    }

    //Iterative
    private static void leftView(Node root) {
        int h = getHeight(root);
        for (int i = 0; i <=h; i++) {
            printLevel(root,i);
            System.out.println();
        }
    }

    private static void printLevel(Node node, int i) {
        if(i==0)
            return;
        if(i==1)
            System.out.print(node.data+" ");
        if(i>1){
            printLevel(node.left,i-1);
            printLevel(node.right,i-1);
        }
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}
