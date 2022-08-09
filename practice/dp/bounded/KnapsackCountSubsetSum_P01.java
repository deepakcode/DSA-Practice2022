package com.practice.dp.bounded;

/**
 * Input: arr[] = {1, 2, 3, 3}, X = 6
 * Output: 3
 * All the possible subsets are {1, 2, 3},
 * {1, 2, 3} and {3, 3}
 * <p>
 * Input: arr[] = {1, 1, 1, 1}, X = 1
 * Output: 4
 */
public class KnapsackCountSubsetSum_P01 {

    public static void main(String[] args) {
        int
                arr[] = {1, 1, 1, 1},
                sum = 1,
                n = arr.length;
        System.out.println(countSubsetSum(arr, n, sum));
    }

    private static int countSubsetSum(int[] arr, int n, int sum) {

        int dp[][] = new int[n + 1][sum + 1];

        // Initialization
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                }
            }
        }
        //logic

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if(arr[i-1]<=j){
                    dp[i][j]= dp[i-1][j-arr[i-1]]
                            +  dp[i-1][j];
                }else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n][sum];   //TODO
    }
}
