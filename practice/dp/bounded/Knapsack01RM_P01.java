package com.practice.dp.bounded;

public class Knapsack01RM_P01 {



    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = wt.length;




        System.out.println(knapsack(wt, val, W, n));
    }

    private static int knapsack(int[] wt, int[] val, int W, int n) {

        int dp[][]=new int[n+1][W+1];

        for(int i=0; i<n+1; i++)
            for(int j=0; j<W+1; j++){
                if(i==0 || j==0)
                    dp[i][j]=0;
                else
                    dp[i][j]=-1;
            }

/*        for(int i=0; i<n+1; i++) {
            for (int j = 0; j < W+1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }*/

        for(int i=1; i<n+1; i++) {
            for (int j = 1; j < W+1; j++) {

               if(wt[i-1]<=j){
                   dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]],
                           dp[i-1][j]);
               }else{
                   dp[i][j]=dp[i-1][j];
               }

            }

        }

        for(int i=0; i<n+1; i++) {
            for (int j = 0; j < W+1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }

        return dp[n][W];
    }
}
