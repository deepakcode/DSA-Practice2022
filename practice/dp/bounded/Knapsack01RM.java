package com.practice.dp.bounded;

public class Knapsack01RM {

    static int W = 50; //30+1
    static int n = 3; //n+1

    static int value = 0;

    static int dp[][] = new int[W + 1][n + 1];

    public static void main(String[] args) {

        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        //int W = 50;
        //int n = wt.length;

        for (int i = 0; i <=W; i++)
            for (int j = 0; j <=n; j++)
                dp[i][j] = -1;

        printMatrics();
        System.out.println(knapsack(wt, val, W, n));
        printMatrics();

    }

    private static void printMatrics() {
        for (int i = 0; i <=W; i++) {
            for (int j = 0; j <=n; j++)
                System.out.print(" " + dp[i][j]);
            System.out.println("\n");
        }
    }

    private static int knapsack(int[] wt, int[] val, int W, int n) {

        // Base condition
        if (n == 0 || W == 0)
            return 0;

        if (dp[W][n] != -1)
            return dp[W][n];

        if (wt[n - 1] > W)

            // Store the value of function call
            // stack in table before return
            return dp[W][n] = knapsack(wt, val,W,n - 1);

        else

            // Return value of table after storing
            return dp[W][n] = Math.max((val[n - 1] +
                            knapsack(wt,
                                    val, W - wt[n - 1],n - 1)),
                    knapsack(wt, val,W,n - 1));

    }
}
