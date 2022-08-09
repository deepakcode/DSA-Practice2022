package com.practice.graph;

import java.util.LinkedList;
import java.util.Queue;

public class MinSwap {
}

class Solution {

    static int minThrow(int N, int arr[]) {

        int boardsize = 31;
        int[] board = new int[boardsize];

        // fill numbers
        for (int i = 0; i < boardsize; i++) {
            board[i] = i;
        }
        // fill Snake and ladder position
        for (int count = 0; count < N; count = count + 2) {
            board[arr[count]] = arr[count + 1];
        }
        return bfsUtil(board);
    }

    static public int bfsUtil(int[] board) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int key = node.id;
            int count = node.count;
            if (key == 30)
                return count;
            for (int i = 1; i <= 6; i++) {
                if (key + i <= 30 && board[key + i] >= key + i)
                    queue.add(new Node(board[key + i], count + 1));
            }
        }
        return -1;
    }
}


class Node {
    int id;
    int count;
    Node(int _id, int _count) {
        id = _id;
        count = _count;
    }
}
