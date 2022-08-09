package com.practice.dp.bounded;

public class KnapsackSubsetSum_P02 {

    public static void main(String[] args) {

        int arr[] = {2, 34, 1, 12, 5, 3}, sum = 7;
        int n=arr.length;
        // Output: True
        //There is a subset (4, 5) with sum 9.
        System.out.println(isSubsetSumPresent(arr,n,sum));


    }

    private static boolean isSubsetSumPresent(int[] arr, int n, int sum) {

        boolean dp[][] = new boolean [n+1][sum+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if(j==0)
                    dp[i][j]=true;
            }
        }


        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if(arr[i-1]<=j){
                    dp[i][j]= dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return dp[n][sum];//TODO
    }
}
