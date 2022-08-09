package com.practice.dp;

import java.util.Arrays;

public class FractionalKnapsack {

    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120,10};
        int wt[] = new int[]{10, 20, 15,10};
        int W = 50;
        int n = wt.length;
        //Find out max value that can fit into bag
        System.out.println(fknapsack(wt, val, W, n));
    }


    private static int fknapsack(int[] wt, int[] val, int totalWeight, int n) {
        Items[] items = new Items[n];
        for (int i = 0; i < n; i++)
            items[i] = new Items(wt[i], val[i], i);
        Arrays.sort(items, (items1, items2) -> items2.cost.compareTo(items1.cost));
        int weightSumTillNow = 0;
        int value = 0;
        for (Items currentItem : items) {
            if ((totalWeight - weightSumTillNow) - currentItem.wt > 0) {
                weightSumTillNow += currentItem.wt;
                value += currentItem.val;
            } else {
                double requiredRatio = (double) (totalWeight - weightSumTillNow) / (double) currentItem.wt;
                weightSumTillNow += requiredRatio * currentItem.wt;
                value += requiredRatio * currentItem.val;
            }
        }
        return value;
    }

    static class Items {

        int wt;
        int val;
        int idx;
        Double cost;

        Items(int wt, int val, int idx) {
            this.wt = wt;
            this.val = val;
            this.idx = idx;
            this.cost = new Double(val / wt);
        }
    }
}
