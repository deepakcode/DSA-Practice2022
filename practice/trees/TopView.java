package com.practice.trees;

import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 *        4
 *   2         6
 * 1    3    5    7
 */
public class TopView {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        topView(root);
        System.out.println("\n---diagonal print----");
        diagnoalPrint(root);
    }

    static class Pair {

        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    private static void topView(Node root) {

        Stack<Pair> stack = new Stack<>();
        stack.add(new Pair(root, 0));

        Map<Integer, Integer> map = new TreeMap<>();

        while (!stack.empty()) {
            Pair pair = stack.pop();

            if (pair.node != null) {

                map.putIfAbsent(pair.hd,pair.node.data); // topview
                //map.put(pair.hd,pair.node.data);// bottom view
                if (pair.node.left != null)
                    stack.push(new Pair(pair.node.left, pair.hd - 1));

                if (root.right != null)
                    stack.push(new Pair(pair.node.right, pair.hd + 1));
            }
        }

        map.entrySet().stream().forEach(s -> System.out.print(s.getValue() + " "));
    }

    private static void diagnoalPrint(Node root) {
        Stack<Pair> stack = new Stack<>();
        stack.add(new Pair(root, 0));
        Map<Integer, LinkedList<Integer>> map = new TreeMap<>();
        while (!stack.empty()) {
            Pair pair = stack.pop();
            if (pair.node != null) {
                LinkedList<Integer> list = map.get(pair.hd);
                if(list==null || list.size()==0){
                    LinkedList<Integer> newList = new LinkedList<>();
                    newList.add(pair.node.data);
                    map.put(pair.hd, newList);
                }else{
                    list.add(pair.node.data);
                    map.put(pair.hd, list);
                }
                if (pair.node.left != null)
                    stack.push(new Pair(pair.node.left, pair.hd + 1));

                if (root.right != null)
                    stack.push(new Pair(pair.node.right, pair.hd
                    ));
            }
        }

        map.entrySet().stream().forEach(s -> System.out.print(s.getValue() + " "));
    }
}