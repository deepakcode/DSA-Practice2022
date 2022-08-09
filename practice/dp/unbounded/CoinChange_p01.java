package com.practice.dp.unbounded;

/**
 Given a value N, if we want to make change for N cents, and we have infinite supply of each of
 S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.

 For example,
 for N = 4 and S = {1,2,3},
 there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
 So output should be 4.

 For N = 10 and S = {2, 5, 3, 6},
 there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 So the output should be 5.
 */
public class CoinChange_p01 {

    public static void main(String[] args) {
        int
                arr[] = {2, 5, 3, 6},
                n = arr.length,
                sum=10;

        System.out.println(coinChange_p01(arr, n,sum));
    }

    private static int coinChange_p01(int[] arr, int n, int sum) {

        int dp[][] = new int[n+1][sum+1];

        //Initialization
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
               if(j==0){
                   dp[i][j]=1;
               }
            }
        }

        //logic

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if(arr[i-1]<=j){
                    dp[i][j]= dp[i][j-arr[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return dp[n][sum]; //TODO
    }
}
