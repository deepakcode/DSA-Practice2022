package com.practice.dp.bounded;

import java.util.ArrayList;
import java.util.List;

public class KnapsackSubsetSumMinDiff {

    public static void main(String[] args) {

        int arr[] = new int[]{1, 6, 16, 5};

        int n = arr.length;
        int range = getRange(arr);
        int W = Math.abs(range / 2);
        boolean dp[][] = new boolean[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0)
                    dp[i][j] = false;
                if (j == 0)
                    dp[i][j] = true;
            }
        }

        printMatrics(n, W, dp);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        printMatrics(n, W, dp);

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= W; i++) {
            if (dp[n][i]) {
                list.add(i);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i : list) {
            min = Math.min(min, range - 2 * i);
        }
        System.out.println("Result : " + min);
    }

    private static int getRange(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
        return sum;
    }

    private static void printMatrics(int n, int W, boolean[][] dp) {
        System.out.println("----------print----------");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                String bool = dp[i][j] ? "T" : "F";
                System.out.print(bool + " ");
            }
            System.out.println("\n");
        }
    }

}
