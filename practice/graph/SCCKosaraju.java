package com.practice.graph;

import java.util.ArrayList;
import java.util.Stack;

public class SCCKosaraju {

    public static void main(String[] args) {

        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(5).add(5);
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(1);
        adj.get(0).add(3);
        adj.get(3).add(4);

        Solution1 s = new Solution1();
        s.kosaraju(V, adj);

    }
}

class Solution1 {
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        //Do DFS
        //G1 - transpose
        //DGF of stack element

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                dfsUtil(u, adj, visited, stack);
            }
        }

        // 2. transpose
        ArrayList<ArrayList<Integer>> tAdj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            tAdj.add(i,new ArrayList<>());

        for (int u = 0; u < V; u++) {
            for (int v = 0; v <adj.get(u).size(); v++) {
                tAdj.get(adj.get(u).get(v)).add(v);
            }
        }

        boolean[] newVisited = new boolean[V];

        Stack<Integer> newStack = new Stack<>();

        int count = 0;

        while (!stack.isEmpty()) {

            int vertex = stack.pop();

            if (!newVisited[vertex]) {

                dfsUtil(vertex, adj, newVisited, newStack);
                count++;
            }
        }
        return count;
    }

    public void dfsUtil(int u, ArrayList<ArrayList<Integer>> adj,
                        boolean[] visited, Stack<Integer> stack) {

        // mark visited
        //do dfs for adjacent vertices

        stack.add(u);

        visited[u] = true;

        for (int v : adj.get(u)) {

            if (!visited[v]) {
                dfsUtil(v, adj, visited, stack);
            }

        }
    } // end dfs

}
