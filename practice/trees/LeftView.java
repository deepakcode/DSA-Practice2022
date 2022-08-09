package com.practice.trees;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 *           4
 *       2         6
 *    1    3    5    7
 */
public class LeftView {

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        int level=0;
        int count=0;
        List<Integer> list = new ArrayList<>();
        leftView(root,level,list);

        list.stream().forEach(System.out::print);
        Map<Integer,Integer> map = new HashMap<>();
        rightView(root,level, map);
        map.entrySet().forEach(s->{
            System.out.print(" "+s.getValue());
        });
}
    private static void leftView(Node node, int level,List<Integer> list) {
        if(node==null)
            return;
        if(level==list.size()) {
           list.add(node.data);
        }
        leftView(node.left, level+1,list);
        leftView(node.right,level+1,list);
    }

    private static void leftView(Node node, int level,Map<Integer,Integer> map) {
        if(node==null)
            return;
        map.putIfAbsent(level,node.data);
        rightView(node.left, level+1,map);
        rightView(node.right,level+1,map);
    }

    private static void rightView(Node node, int level,Map<Integer,Integer> map) {
        if(node==null)
            return;
        map.put(level,node.data);
        rightView(node.left, level+1,map);
        rightView(node.right,level+1,map);
    }
}
