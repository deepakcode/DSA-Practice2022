package com.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {

    private static int V; //total vertices
    public static LinkedList<Integer>[] adj; // array of list or // list of list
    static int parent=-1;

    public Graph(int V) {
        this.V = V+1;
        adj = new LinkedList[V+1];
        for (int i = 0; i <V+1; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    private void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public static void main(String[] args) {
        int V = 4;
        Graph g = new Graph(V);
        g.addEdge(4, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);


        /**
         *       4
         *       |
         * 1.... 2
         *       |
         *       3
         */
//        System.out.println("\n-------DFS--------");
//        dfs(V);
//        System.out.println("\n------BFS---------");
//        bfsOfGraph(V);
//        System.out.println("\n------isCycle---------");

        System.out.println(isCycle(V,adj));
    }


    public static boolean isCycle(int V, LinkedList<Integer>[] adj) {
        boolean[] visited =visited = new boolean[V+1];
        for(int i=0; i<adj.length;i++){
            if(!visited[i])
                if(isCyclicUtil(i,visited,-1,adj)){
                    return true;
                }
        }
        return false;
    }


    private static boolean isCyclicUtil(int v, boolean[] visited, int parent,
                                LinkedList<Integer>[] adj) {
        visited[v]=true;
        for(int i:adj[v]) {
            if(!visited[i]){
                if(isCyclicUtil(i,visited,v,adj))
                    return true;
            }else if(i!=parent)
                return true;

        }
        return false;
    }

    private static void dfs(int V) {
        boolean[] visited = new boolean[V + 1];//default is false
        dfsUtil(0, visited);
    }

    private static void dfsUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int connectedVertex:adj[v]) {
            if (!visited[connectedVertex]) {
                dfsUtil(connectedVertex, visited);
            }
        }
    }

    public static void bfsOfGraph(int V) {
        boolean[] visited = new boolean[V + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (queue.size() > 0) {
            int current = queue.poll();
            if (!visited[current]) {
                visited[current] = true;
                System.out.print(current + " ");
                for (int connectedVertex : adj[current]) {
                    if (!visited[connectedVertex]) {
                        queue.add(connectedVertex);
                    }
                }
            }
        }//while
    }// bfsOfGraph




}//class
