package com.practice.dp.bounded;

public class KnapsackSubsetSum {

    public static void main(String[] args) {

        int arr[] = new int[]{3, 34, 4, 12, 5, 2};
        int n = arr.length; //0....n
        int sum = 9; // 0----9

        boolean dp[][] = new boolean[n + 1][sum + 1];
        fillBaseCondition(n, sum, dp);
        print(n, sum, dp);

        for (int i = 1; i <n; i++) {
            for (int j = 1; j <sum; j++) {
                // dp[i][j] =
                if (arr[i-1] <= j) {
                    //sum can be or can not be
                    dp[i][j] = dp[i - 1][j - arr[i-1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println("Result : "+dp[n][sum]);

        print(n, sum, dp);

    }

    private static void fillBaseCondition(int n, int sum, boolean[][] dp) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < sum; j++) {
                if (i == 0)
                    dp[i][j] = false;
                if (j == 0)
                    dp[i][j] = true;

            }
        }
    }

    private static void print(int n, int sum, boolean[][] dp) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < sum; j++) {
                String bool = dp[i][j] ? "T" : "F";
                System.out.print(bool + " ");
            }
            System.out.println();
        }
    }
}
