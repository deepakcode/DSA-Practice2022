package com.practice.dp.bounded;

public class Knapsack01RT {


    static int n = 3; //n+1
    static int W = 50; //30+1

    static int value = 0;

    static int dp[][] = new int[n + 1][W + 1];

    public static void main(String[] args) {

        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        //int W = 50;
        //int n = wt.length;

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= W; j++)
                dp[i][j] = -1;


       // printMatrics();
        knapsack(wt, val, W, n);
        //printMatrics();

    }

    private static void printMatrics() {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++)
                System.out.print(" " + dp[i][j]);
            System.out.println("\n");
        }
    }

    private static void knapsack(int[] wt, int[] val, int W, int n) {

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++){
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }

        printMatrics();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++){
                if(wt[n-1]<=j)
                    dp[i][j] = Math.max(val[n-1]+ dp[i-1][j-wt[n-1]], dp[i][j-1]);
                else
                    dp[i][j] = dp[i][j-1];
            }
        }


        printMatrics();

    }
}
      /*  if (wt[n - 1] > W)

            // Store the value of function call
            // stack in table before return
            return dp[W][n] = knapsack(wt, val,W,n - 1);

        else

            // Return value of table after storing
            return dp[W][n] = Math.max((val[n - 1] +
                            knapsack(wt,
                                    val, W - wt[n - 1],n - 1)),
                    knapsack(wt, val,W,n - 1));*/

