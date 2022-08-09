package com.practice.dp.unbounded;

public class CoinChangeUnboundedKnapsack {

    public static void main(String[] args) {
        // No of ways (+)
        int coins[] = { 1, 5, 10 };

        int n = coins.length;
        int w=12;
        int dp[][] = new int[n+1][w+1];

        //getNumberOfWays(coins,n, w, dp);

        System.out.println(getNumberOfWays(coins,n, w, dp));
    }

    private static int getNumberOfWays(int coins[],int n, int w, int dp[][]){

        for (int i = 0; i <=n; i++) {
            for (int j = 0; j <=w ; j++) {
                if(i==0)
                    dp[i][j]=0;
                if(j==0)
                    dp[i][j]=1;
            }
        }

        print(n,w,dp);

        for (int i = 1; i <=n; i++) { // coins
            for (int j = 1; j <=w ; j++) { // amount
                if(coins[i-1]<=j){
                    dp[i][j] = dp[i][j-coins[i-1]]
                            + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print(n,w,dp);


        return dp[n][w];
    }

    private static void print(int n, int sum, int[][] dp) {
        System.out.println("--------------------");
        for (int i = 0; i <=n; i++) {
            for (int j = 0; j <=sum; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
