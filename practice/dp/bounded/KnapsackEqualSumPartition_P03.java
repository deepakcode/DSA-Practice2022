package com.practice.dp.bounded;

public class KnapsackEqualSumPartition_P03 {

    public static void main(String[] args) {
        int arr[] = {3, 24, 1, 12, 5, 3}, sum = 7;
        int n=arr.length;

        System.out.println(isEqualSumPartitionExist(arr,n,sum));
    }

    private static boolean isEqualSumPartitionExist(int[] arr, int n, int sum1) {

        int sum=0;
        for (int a:arr) {
            sum+=a;
        }
        if(sum%2!=0)
            return false;
        else
            sum=sum/2;
        System.out.println("s -> "+sum);

        boolean dp[][] = new boolean[n+1][sum+1];
        // Initilization
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
               if(j==0)
                   dp[i][j]=true;
            }
        }

        // logic
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
              if(arr[i-1]<=j){
                  dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
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
        return dp[n][sum];
    }
}
