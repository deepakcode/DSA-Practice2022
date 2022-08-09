package com.practice.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgo {
    public static void main(String[] args) {
        int graph[][] = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 0);
    }
}

class ShortestPath {

    public void dijkstra(int[][] graph, int source) {
        int V = graph.length;

        int[] weight= new int[V];
        Arrays.fill(weight,Integer.MAX_VALUE);

        PriorityQueue<Pair> pQueue = new PriorityQueue<Pair>(V, Comparator.comparingInt(a -> a.wt));

        pQueue.add(new Pair(0,source));

        weight[source]=0;

        while(pQueue.size()>0){
            Pair current = pQueue.poll();
            int u = current.u;
            int wt=current.wt;
            for(int v = 0; v < V; v++) {
                if(0!=graph[u][v]){
                    if(wt+graph[u][v]<weight[v]){
                        weight[v]=wt+graph[u][v];
                        pQueue.add(new Pair(v,weight[v]));
                    }
                }
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.println(i+" "+weight[i]);
        }
    }
}
 class Pair {
    int u;
    int wt;
    Pair(int _u,int _wt){
        u=_u;
        wt=_wt;
    }
 }
