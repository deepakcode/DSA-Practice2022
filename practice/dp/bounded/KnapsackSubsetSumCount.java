package com.practice.dp.bounded;

public class KnapsackSubsetSumCount {

    public static void main(String[] args) {

        int arr[] = new int[]{3,3,3,3};
        int n = arr.length; //0....n
        int sum = 6; // 0----9

         int dp[][] = new int[n + 1][sum + 1];
        print(n, sum, dp);
        initialization(n, sum, dp);
        print(n, sum, dp);
        logic(arr, n, sum, dp);
        System.out.println("Result : "+dp[n][sum]);
        print(n, sum, dp);

    }

    private static void initialization(int n, int sum, int[][] dp) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < sum; j++) {
                if (i == 0)
                    dp[i][j] = 0;
                if (j == 0)
                    dp[i][j] = 1;
            }
        }
    }


    private static void logic(int[] arr, int n, int sum, int[][] dp) {
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=sum; j++) {
                if(arr[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }
            }
        }
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
