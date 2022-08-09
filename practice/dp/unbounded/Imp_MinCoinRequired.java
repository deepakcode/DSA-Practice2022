package com.practice.dp.unbounded;

/**
 * Input: coins[] = {25, 10, 5}, V = 30
 * Output: Minimum 2 coins required We can use one coin of 25 cents and one of 5 cents
 */
public class Imp_MinCoinRequired {

    public static void main(String[] args) {
        int
                coins[] = {25, 10, 5},
                sum = 30,
                n = coins.length;

        System.out.println(minCoinRequired(coins, n, sum));

    }

    private static int minCoinRequired(int[] coins, int n, int sum) {

        int dp[][] = new int[n + 1][sum + 1];

        // Initialization -01
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    dp[i][j] = Integer.MAX_VALUE - 1; // infinite
                } else if (j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        // Initialization -02
        for (int j = 1; j < sum + 1; j++) {
            if (j % coins[0] == 0) {
                System.out.println("j " + j);
                System.out.println("c " + coins[0]);
                dp[1][j] = j / coins[0];
            } else {
                dp[1][j] = Integer.MAX_VALUE - 1;
            }
        }

        //logic
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        print(n, sum, dp);

        return dp[n][sum]; //TODO
    }

    private static void print(int n, int sum, int[][] dp) {
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                System.out.print(dp[i][j] == 2147483646 ? "INF " : dp[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
