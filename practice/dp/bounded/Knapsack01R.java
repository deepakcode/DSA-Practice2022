package com.practice.dp.bounded;

public class Knapsack01R {

    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = wt.length;
        System.out.println(knapsack(wt, val, W, n));
    }

    private static int knapsack(int[] wt, int[] val, int W, int n) {
        if (W == 0 || n == 0)
            return 0;
        if (wt[n - 1] <= W) {
            return Math.max(val[n - 1] + knapsack(wt, val, (W - wt[n - 1]), n - 1),
                    knapsack(wt, val, W, n - 1));
        } else {
            return knapsack(wt, val, W, n - 1);
        }
    }
}
